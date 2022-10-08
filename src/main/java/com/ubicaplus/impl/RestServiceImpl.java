package com.ubicaplus.impl;

import com.ubicaplus.dao.UbicaDao;
import com.ubicaplus.model.UbicaDetail;
import com.ubicaplus.payload.*;
import com.ubicaplus.service.RestService;
import com.ubicaplus.service.SoapClient;
import com.ubicaplus.utility.Utility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Named;
import java.io.*;
import java.util.Date;

/**
 * REST API Middleware Service Implementation
 */
@Configuration
@PropertySource("classpath:application.properties")
@Named("restService")
public class RestServiceImpl implements RestService {

    private SoapClient soapClient = new SoapClient();

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UbicaDao dao;

    @Value("${userlist.file.location}")
    String userListFileLocation;

    public RestServiceImpl() {
    }

    /**
     * Forward the Users request to the Provider Service and Respond accordingly
     * @param request
     * @return CIFIN - contains the Provider Service response data
     * @throws InternalServerException
     * @throws UnauthorizedServerException
     * @throws BadRequestException
     * @throws InvalidUserException
     */
    @Override
    public CIFIN getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException,
            BadRequestException, InvalidUserException {

        Date requestDateTime = new Date();

        // Check if User credential exists in the file users.txt
        boolean userIsValid = false;
        try {
            userIsValid = this.isValidUser(request.getReq_usuario(), request.getReq_password());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!userIsValid) {
            throw new InvalidUserException("No Valid User");
        }

        // User is valid so go for the provider service SOAP request
        SoapResponse soapResponse = soapClient.call(request);

        if (soapResponse.getErrorMessage() != null && soapResponse.getErrorMessage() != "") {
            /*
                An error happened at the provider service soap request.
                Throw the InternalServerException with the available error message
             */

            throw new InternalServerException(soapResponse.getErrorMessage());

        } else if (soapResponse.isUnauthorized()) {
            /*
                Provider service respond that the User is Anauthorized
                Throw the UnauthorizedServerException with the error message
             */

            throw new UnauthorizedServerException();
        } else if (soapResponse.getCifinError() != null) {
            /*
                Provider service respond that there is something wrong in the request parameters
                Throw the UnauthorizedServerException with the error message sent by the Provider Service
             */

            throw new BadRequestException(soapResponse.getCifinError().getError().getMensajeError());
        } else {
            //No error and Provider Service respond with the available data

            CIFIN response = new CIFIN();
            response.setTercero(modelMapper.map(soapResponse.getCIFIN().getTercero(), Tercero.class));
            try {
                // Prepare the data model to persist in the database
                UbicaDetail detail = modelMapper.map(response.getTercero(), UbicaDetail.class);
                detail.setReqUsuario(request.getReq_usuario());
                detail.setReqFechaconsulta(requestDateTime);
                detail.setGeneroTercero(response.getTercero().getUbicaPlusCifin().getGeneroTercero());

                if (response.getTercero().getUbicaPlusCifin().getDirecciones() != null
                        && response.getTercero().getUbicaPlusCifin().getDirecciones().getDireccion() != null
                        && response.getTercero().getUbicaPlusCifin().getDirecciones().getDireccion().size() > 0) {
                    this.setDirecciones(detail, response.getTercero().getUbicaPlusCifin().getDirecciones().getDireccion().get(0));
                }

                if (response.getTercero().getUbicaPlusCifin().getTelefonos() != null
                        && response.getTercero().getUbicaPlusCifin().getTelefonos().getTelefono() != null
                        && response.getTercero().getUbicaPlusCifin().getTelefonos().getTelefono().size() > 0) {
                    this.setTelefonos(detail, response.getTercero().getUbicaPlusCifin().getTelefonos().getTelefono().get(0));
                }

                if (response.getTercero().getUbicaPlusCifin().getCelulares() != null
                        && response.getTercero().getUbicaPlusCifin().getCelulares().getCelular() != null
                        && response.getTercero().getUbicaPlusCifin().getCelulares().getCelular().size() > 0) {
                    this.setCelulares(detail, response.getTercero().getUbicaPlusCifin().getCelulares().getCelular().get(0));
                }

                if (response.getTercero().getUbicaPlusCifin().getMails() != null
                        && response.getTercero().getUbicaPlusCifin().getMails().getMail() != null
                        && response.getTercero().getUbicaPlusCifin().getMails().getMail().size() > 0) {
                    this.setMails(detail, response.getTercero().getUbicaPlusCifin().getMails().getMail().get(0));
                }

                // Persist the data
                dao.save(detail);

                // After saving data send the response to the user
                return response;

            } catch (Exception e) {
                // Error occurred while saving into the database
                e.printStackTrace();
                String exception = Utility.getStringFromException(e);
                throw new InternalServerException(exception);
            }
        }
    }

    /**
     * Set the Mails data in the data model
     * before persist it to the database
     * @param detail
     * @param mail
     */
    private void setMails(UbicaDetail detail, Mail mail) {
        detail.setMailNoReportes(mail.getNoReportes());
        detail.setMailPrimerReporte(mail.getPrimerReporte());
        detail.setMailUltimoReporte(mail.getUltimoReporte());
        detail.setMailCorreo(mail.getCorreo());
    }

    /**
     * Set the Celulares data in the data model
     * before persist it to the database
     * @param detail
     * @param celular
     */
    private void setCelulares(UbicaDetail detail, Celular celular) {
        detail.setCelularCelPos(celular.getCelPos());
        detail.setCelularNoReportes(celular.getNoReportes());
        detail.setCelularProductoActivo(celular.getProductoActivo());
        detail.setCelularSectorEconomico(celular.getSectorEconomico());
        detail.setCelularPrimerReporte(celular.getPrimerReporte());
        detail.setCelularUltimoReporte(celular.getUltimoReporte());
        detail.setCelularCelular(celular.getCelular());
    }

    /**
     * Set the Telefonos data in the data model
     * before persist it to the database
     * @param detail
     * @param telefono
     */
    private void setTelefonos(UbicaDetail detail, Telefono telefono) {
        detail.setTelefonoTelPos(telefono.getTelPos());
        detail.setTelefonoNoReportes(telefono.getNoReportes());
        detail.setTelefonoProductoActivo(telefono.getProductoActivo());
        detail.setTelefonoTipoUbicacion(telefono.getTipoUbicacion());
        detail.setTelefonoSectorEconomico(telefono.getSectorEconomico());
        detail.setTelefonoPrimerReporte(telefono.getPrimerReporte());
        detail.setTelefonoUltimoReporte(telefono.getUltimoReporte());
        detail.setTelefonoPrefijo(telefono.getPrefijo());
        detail.setTelefonoTelefono(telefono.getTelefono());
        detail.setTelefonoCiudad(telefono.getCiudad());
    }

    /**
     * Set the Direcciones data in the data model
     * before persist it to the database
     * @param detail
     * @param direccion
     */
    private void setDirecciones(UbicaDetail detail, Direccion direccion) {
        detail.setDireccionDirPos(direccion.getDirPos());
        detail.setDireccionNoReportes(direccion.getNoReportes());
        detail.setDireccionProductoActivo(direccion.getProductoActivo());
        detail.setDireccionTipoUbicacion(direccion.getTipoUbicacion());
        detail.setDireccionSectorEconomico(direccion.getSectorEconomico());
        detail.setDireccionPrimerReporte(direccion.getPrimerReporte());
        detail.setDireccionUltimoReporte(direccion.getUltimoReporte());
        detail.setDireccionDireccion(direccion.getDireccion());
        detail.setDireccionCiudad(direccion.getCiudad());
    }

    /**
     * Check if user exists in the users.txt file
     * @param req_usuario
     * @param req_password
     * @return
     * @throws IOException
     */
    private boolean isValidUser(String req_usuario, String req_password) throws IOException {
        FileInputStream fis = new FileInputStream(userListFileLocation);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = in.readLine()) != null) {
            String[] values = line.split(":");
            if (req_usuario.equalsIgnoreCase(values[0])
            && req_password.equalsIgnoreCase(values[1])) {
                in.close();
                return true;
            }
        }
        in.close();

        return false;
    }
}



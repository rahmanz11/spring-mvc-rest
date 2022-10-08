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

    @Override
    public RestResponse getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException,
            BadRequestException, InvalidUserException {

        Date requestDateTime = new Date();

        boolean userIsValid = false;
        try {
            userIsValid = this.isValidUser(request.getReq_usuario(), request.getReq_password());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!userIsValid) {
            throw new InvalidUserException("No Valid User");
        }

        SoapResponse soapResponse = soapClient.call(request);

        if (soapResponse.getErrorMessage() != null && soapResponse.getErrorMessage() != "") {
            throw new InternalServerException(soapResponse.getErrorMessage());
        } else if (soapResponse.isUnauthorized()) {
            throw new UnauthorizedServerException();
        } else if (soapResponse.getCifinError() != null) {
            throw new BadRequestException(soapResponse.getCifinError());
        } else {
            RestResponse response = new RestResponse();
            response.setCIFIN(new CIFIN());
            response.getCIFIN().setTercero(modelMapper.map(soapResponse.getCIFIN().getTercero(), Tercero.class));
            try {
                UbicaDetail detail = modelMapper.map(response.getCIFIN().getTercero(), UbicaDetail.class);
                detail.setReqUsuario(request.getReq_usuario());
                detail.setReqFechaconsulta(requestDateTime);
                detail.setGeneroTercero(response.getCIFIN().getTercero().getUbicaPlusCifin().getGeneroTercero());

                if (response.getCIFIN().getTercero().getUbicaPlusCifin().getDirecciones() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getDirecciones().getDireccion() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getDirecciones().getDireccion().size() > 0) {
                    this.setDirecciones(detail, response.getCIFIN().getTercero().getUbicaPlusCifin().getDirecciones().getDireccion().get(0));
                }

                if (response.getCIFIN().getTercero().getUbicaPlusCifin().getTelefonos() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getTelefonos().getTelefono() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getTelefonos().getTelefono().size() > 0) {
                    this.setTelefonos(detail, response.getCIFIN().getTercero().getUbicaPlusCifin().getTelefonos().getTelefono().get(0));
                }

                if (response.getCIFIN().getTercero().getUbicaPlusCifin().getCelulares() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getCelulares().getCelular() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getCelulares().getCelular().size() > 0) {
                    this.setCelulares(detail, response.getCIFIN().getTercero().getUbicaPlusCifin().getCelulares().getCelular().get(0));
                }

                if (response.getCIFIN().getTercero().getUbicaPlusCifin().getMails() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getMails().getMail() != null
                        && response.getCIFIN().getTercero().getUbicaPlusCifin().getMails().getMail().size() > 0) {
                    this.setMails(detail, response.getCIFIN().getTercero().getUbicaPlusCifin().getMails().getMail().get(0));
                }

                dao.save(detail);
            } catch (Exception e) {
                e.printStackTrace();
                String exception = Utility.getStringFromException(e);
                throw new InternalServerException(exception);
            }
            return response;
        }
    }

    private void setMails(UbicaDetail detail, Mail mail) {
        detail.setMailNoReportes(mail.getNoReportes());
        detail.setMailPrimerReporte(mail.getPrimerReporte());
        detail.setMailUltimoReporte(mail.getUltimoReporte());
        detail.setMailCorreo(mail.getCorreo());
    }

    private void setCelulares(UbicaDetail detail, Celular celular) {
        detail.setCelularCelPos(celular.getCelPos());
        detail.setCelularNoReportes(celular.getNoReportes());
        detail.setCelularProductoActivo(celular.getProductoActivo());
        detail.setCelularSectorEconomico(celular.getSectorEconomico());
        detail.setCelularPrimerReporte(celular.getPrimerReporte());
        detail.setCelularUltimoReporte(celular.getUltimoReporte());
        detail.setCelularCelular(celular.getCelular());
    }

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



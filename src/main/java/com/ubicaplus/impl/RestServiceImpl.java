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

        boolean userIsValid = false;
        try {
            userIsValid = this.isValidUser(request.getReq_usuario(), request.getReq_password());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!userIsValid) {
            throw new InvalidUserException("No Valid User");
        }

        UbicaDetail detail = new UbicaDetail();
        detail.setRequestDateTime(new Date());

        SoapResponse soapResponse = soapClient.call(request);
        detail.setResponseDateTime(new Date());

        try {
            dao.save(detail);
        } catch (Exception e) {
            e.printStackTrace();
            String exception = Utility.getStringFromException(e);

            throw new InternalServerException(exception);
        }

        RestResponse response = modelMapper.map(soapResponse, RestResponse.class);

        if (soapResponse.getErrorMessage() != null && soapResponse.getErrorMessage() != "") {
            throw new InternalServerException(response.getErrorMessage());
        }
        if (soapResponse.isUnauthorized()) {
            throw new UnauthorizedServerException();
        }
        if (soapResponse.getCifinError() != null) {
            throw new BadRequestException(response.getCifinError());
        }
        return response;
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



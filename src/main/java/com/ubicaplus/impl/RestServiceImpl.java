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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@Configuration
@PropertySource("classpath:application.properties")
@Named("restService")
public class RestServiceImpl implements RestService {

    private SoapClient soapClient = new SoapClient();

    @Value(value = "${auth.username}")
    private String userName;

    @Value(value = "${auth.password}")
    private String password;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UbicaDao dao;

    public RestServiceImpl() {
    }

    @Override
    public RestResponse getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException, BadRequestException {
        UbicaDetail detail = new UbicaDetail();
        detail.setRequestDateTime(new Date());

        SoapResponse soapResponse = soapClient.call(request, userName, password);
        detail.setResponseDateTime(new Date());

        if (soapResponse.getErrorMessage() != null && soapResponse.getErrorMessage() != "") {
            detail.setResponse(soapResponse.getErrorMessage());
            detail.setStatus(500L);
        } else if (soapResponse.isUnauthorized()) {
            detail.setResponse("Access Unauthorized");
            detail.setStatus(401L);
        } else if (soapResponse.getCifinError() != null) {
            detail.setResponse(soapResponse.getSoapResponseValue());
            detail.setStatus(400L);
        } else {
            detail.setResponse(soapResponse.getSoapResponseValue());
            detail.setStatus(200L);
        }

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
}



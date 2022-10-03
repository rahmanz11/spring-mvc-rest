package com.ubicaplus.impl;

import com.ubicaplus.payload.*;
import com.ubicaplus.service.RestService;
import com.ubicaplus.service.SoapClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Named;

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

    public RestServiceImpl() {
    }

    @Override
    public RestResponse getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException, BadRequestException {
        SoapResponse soapResponse = soapClient.call(request, userName, password);
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



package com.ubicaplus.service;

import com.ubicaplus.payload.*;

public interface RestService {
    RestResponse getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException, BadRequestException;
}

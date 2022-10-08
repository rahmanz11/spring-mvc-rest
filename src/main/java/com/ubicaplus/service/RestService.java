package com.ubicaplus.service;

import com.ubicaplus.payload.*;

/**
 * REST API Middleware Service Interface
 */
public interface RestService {
    CIFIN getData(SoapRequest request) throws InternalServerException, UnauthorizedServerException,
            BadRequestException, InvalidUserException;
}

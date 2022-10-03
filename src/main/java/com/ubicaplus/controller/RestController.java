package com.ubicaplus.controller;

import com.ubicaplus.payload.*;
import com.ubicaplus.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    @Autowired
    private RestService restService;

    @RequestMapping(value = "call-provider-service", method = RequestMethod.POST)
    public ResponseEntity<?> submit(@RequestBody SoapRequest request) {
        try {
            RestResponse response = restService.getData(request);
            return new ResponseEntity<>(response.getCifin(), HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
        } catch (InternalServerException e) {
            String message = e.getMessage();
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UnauthorizedServerException e) {
            String message = e.getMessage();
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }
}

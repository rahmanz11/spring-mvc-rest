package com.ubicaplus.controller;

import com.ubicaplus.payload.*;
import com.ubicaplus.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bridge API REST Controller
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    @Autowired
    private RestService restService;

    /**
     * published and exposed API endpoint (call-provider-service) to receive the users request and response accordingly
     * @param request SoapRequest class included all the parameter coming through the Bridge API Request
     * @return CIFIN - will contain the Provider Service response data
     *         Message - will contain the ErrorText
     */
    @RequestMapping(value = "call-provider-service", method = RequestMethod.POST)
    public ResponseEntity<?> submit(@RequestBody SoapRequest request) {
        try {
            CIFIN response = restService.getData(request);
            return new ResponseEntity<CIFIN>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
        } catch (InternalServerException e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UnauthorizedServerException e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.UNAUTHORIZED);
        } catch (InvalidUserException e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}

package com.ubicaplus.controller;

import com.ubicaplus.payload.SoapRequest;
import com.ubicaplus.payload.SoapResponse;
import com.ubicaplus.service.SoapClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * Test class to directly test the Provider Web Service
 */
public class SoapClientTest extends BaseWebApplicationContextTests {
    @Autowired
    private SoapClient soapClient;
    private SoapRequest request;

    /**
     * Setup the request parameters
     */
    @Before
    public void setUp() {
        request = new SoapRequest();
        request.setCodigoInformacion("5632");
        request.setMotivoConsulta("24");
        request.setNumeroIdentificacion("262744");
        request.setPrimerApellido("SEPULVEDA");
        request.setTipoIdentificacion("1");
        request.setReq_usuario("307883");
        request.setReq_password("Equidad2208*");
    }

    /**
     * Test if the provider service response data are available
     */
    @Test
    public void testSoapResponse() {
        SoapResponse response = soapClient.call(request);
        assertTrue(response.getCIFIN().getTercero() != null);
    }

    /**
     * Test if the provider service respond with Bad request
     */
    @Test
    public void testSoapResponseErrorCode4() {
        request.setNumeroIdentificacion(null);
        SoapResponse response = soapClient.call(request);
        assertTrue(response.getCifinError().getError().getCodigoError().trim().equals("4"));
    }

    /**
     * Test if unauthorized
     */
    @Test
    public void test401UnauthorizedWithInvalidCredentials() {
        request.setReq_usuario("dummy");
        request.setReq_password("dummy");
        SoapResponse response = soapClient.call(request);
        assertTrue(response.isUnauthorized() == true);
    }
}

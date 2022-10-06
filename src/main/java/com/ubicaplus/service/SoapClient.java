package com.ubicaplus.service;

import com.ubicaplus.payload.CIFIN;
import com.ubicaplus.payload.CifinError;
import com.ubicaplus.payload.SoapRequest;
import com.ubicaplus.payload.SoapResponse;
import com.ubicaplus.utility.Utility;
import com.webservice.ubicaplus.dto.ParametrosUbicaPlusDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.BindingProvider;
import java.io.StringReader;
import java.util.Map;

@Component
public class SoapClient {

	public SoapResponse call(SoapRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        com.webservice.ubicaplus.UbicaPlusWS ubicaws = (com.webservice.ubicaplus.UbicaPlusWS) context.getBean("ubicaClient");

        if (request.getReq_usuario() != null && request.getReq_usuario().trim() != ""
		&& request.getReq_password() != null && request.getReq_password().trim() != "") {
			Map<String, Object> reqContext = ((BindingProvider)
					ubicaws).getRequestContext();
			reqContext.put(BindingProvider.USERNAME_PROPERTY, request.getReq_usuario());
			reqContext.put(BindingProvider.PASSWORD_PROPERTY, request.getReq_password());
		}

		org.xmlsoap.schemas.soap.encoding.String soapResponse;
        SoapResponse response = new SoapResponse();
		try {
			soapResponse = ubicaws.consultaUbicaPlus(this.prepareSoapRequest(request));

			String responseString = soapResponse.getValue();
			System.out.println("Response String: " + responseString);

			response.setSoapResponseValue(responseString);

			this.prepareSoapResponse(responseString, response);

		} catch (RuntimeException e) {
			e.printStackTrace();
			if (e.getCause().getMessage().contains("401: Unauthorized")) {
				System.err.println("Unauthorized Access");
				response.setUnauthorized(true);
			} else {
				String exception = Utility.getStringFromException(e);
				System.err.println(String.format("SOAP Exception: %s", exception));
				response.setErrorMessage(exception);
			}
		}

		return response;
	}

	private ParametrosUbicaPlusDTO prepareSoapRequest(SoapRequest request) {
		ParametrosUbicaPlusDTO dto = new ParametrosUbicaPlusDTO();

		if (request.getCodigoInformacion() != null && request.getCodigoInformacion().trim() != "") {
			org.xmlsoap.schemas.soap.encoding.String codigoInformacion = new org.xmlsoap.schemas.soap.encoding.String();
			codigoInformacion.setValue(request.getCodigoInformacion());
			dto.setCodigoInformacion(codigoInformacion);
		}

		if (request.getTipoIdentificacion() != null && request.getTipoIdentificacion().trim() != "") {
			org.xmlsoap.schemas.soap.encoding.String tipoIdentificacion = new org.xmlsoap.schemas.soap.encoding.String();
			tipoIdentificacion.setValue(request.getTipoIdentificacion());
			dto.setTipoIdentificacion(tipoIdentificacion);
		}

		if (request.getMotivoConsulta() != null && request.getMotivoConsulta().trim() != "") {
			org.xmlsoap.schemas.soap.encoding.String motivoConsulta = new org.xmlsoap.schemas.soap.encoding.String();
			motivoConsulta.setValue(request.getMotivoConsulta());
			dto.setMotivoConsulta(motivoConsulta);
		}

		if (request.getNumeroIdentificacion() != null && request.getNumeroIdentificacion().trim() != "") {
			org.xmlsoap.schemas.soap.encoding.String numeroIdentificacion = new org.xmlsoap.schemas.soap.encoding.String();
			numeroIdentificacion.setValue(request.getNumeroIdentificacion());
			dto.setNumeroIdentificacion(numeroIdentificacion);
		}

		if (request.getPrimerApellido() != null && request.getPrimerApellido().trim() != "") {
			org.xmlsoap.schemas.soap.encoding.String primerApellido = new org.xmlsoap.schemas.soap.encoding.String();
			primerApellido.setValue(request.getPrimerApellido());
			dto.setPrimerApellido(primerApellido);
		}

		return dto;
	}

	private void prepareSoapResponse(String responseString, SoapResponse response) {
		JAXBContext jaxbContext;
		try {
			if (!responseString.contains("CifinError")) {
				jaxbContext = JAXBContext.newInstance(CIFIN.class);
			} else {
				jaxbContext = JAXBContext.newInstance(CifinError.class);
			}

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			if (!responseString.contains("CifinError")) {
				CIFIN cifin = (CIFIN) jaxbUnmarshaller.unmarshal(new StringReader(responseString));
				response.setCIFIN(cifin);
			} else {
				CifinError cifinError = (CifinError) jaxbUnmarshaller.unmarshal(new StringReader(responseString));
				response.setCifinError(cifinError);
			}
		} catch (JAXBException e) {
			String exception = Utility.getStringFromException(e);
			System.err.println(String.format("Response conversion: %s", exception));
			response.setErrorMessage(exception);
		}
	}

}

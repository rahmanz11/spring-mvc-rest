package com.ubicaplus.service;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Password callback class to be used by the WSS4JOutInterceptor
 * The password callback class allows you to retrieve the password
 * for a given user so that WS-Security can determine if they're authorized *
 */
public class ClientPasswordCallback implements CallbackHandler {

	private Map<String, String> userPasswords = new HashMap<>();
	private Map<String, String> keyPasswords = new HashMap<>();

	public ClientPasswordCallback() {
		keyPasswords.put("equidadtes", "Rie22*");
	}

	/**
	 * Override method
	 * @param callbacks
	 */
	public void handle(Callback[] callbacks) {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
			String id = pwcb.getIdentifier();
			String pass = keyPasswords.get(id);
			pwcb.setPassword(pass);
		}
	}
}
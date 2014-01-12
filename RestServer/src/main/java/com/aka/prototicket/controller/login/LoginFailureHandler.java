package com.aka.prototicket.controller.login;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.aka.prototicket.model.*;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler 
{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException auth)
			throws IOException, ServletException {
		
		ObjectMapper mapper = new ObjectMapper();
		LoginStatus status = new LoginStatus(false, false, null, "Login failed. Try again.", null);
		logger.error("Login failed: " + auth.getMessage());
		OutputStream out = response.getOutputStream();
		mapper.writeValue(out, status);
	}

}

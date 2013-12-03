package com.aka.prototicket.controller.login;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.aka.prototicket.model.*;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler
{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		
		logger.info("Login Successful");
		ObjectMapper mapper = new ObjectMapper();
		LoginStatus status = new LoginStatus(true, auth.isAuthenticated(), auth.getName(), null);
		HttpSession session = request.getSession();
		session.setAttribute("loginStatus", status);
		
		OutputStream out = response.getOutputStream();
		mapper.writeValue(out, status);
	}

}

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aka.prototicket.db.dao.UserDAO;
import com.aka.prototicket.db.entity.User;
import com.aka.prototicket.model.*;
import com.aka.prototicket.model.dto.UserDto;
import com.aka.prototicket.model.mapping.UserMapper;

@Transactional
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler
{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	private UserMapper userMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		
		logger.info("Login Successful");
		ObjectMapper mapper = new ObjectMapper();
		
		LoginStatus status;
		User user = userDAO.getUser(auth.getName());
		if(user == null)
		{
			UserDto userDto = new UserDto();
			userDto.setEmail("dev@user");
			userDto.setFirstname("developer");
			userDto.setId(1);
			userDto.setLastname("developer");
			userDto.setLogin("developer");
			userDto.setPassword("developer");

			status=  new LoginStatus(true, auth.isAuthenticated(), auth.getName(), null, userDto);
		}
		else
		{
			UserDto userDto = userMapper.toDto(user);
			
			status = new LoginStatus(true, auth.isAuthenticated(), auth.getName(), null, userDto);
		}
	   
		HttpSession session = request.getSession();
		session.setAttribute("loginStatus", status);
		
		OutputStream out = response.getOutputStream();
		mapper.writeValue(out, status);
	}

	
	
}

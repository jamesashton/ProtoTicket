package com.aka.prototicket.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController 
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/resources/login/login.do", method=RequestMethod.GET)
	public String login() {
		logger.info("INSIDE LOGIN!");
		return "login";
	}
}


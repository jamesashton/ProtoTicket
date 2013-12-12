package com.aka.prototicket.controller.user;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aka.prototicket.controller.home.HomeController;
import com.aka.prototicket.model.*;
@Controller
public class UserController 
{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/resources/app/loginstatus.json", method = RequestMethod.GET)
	@ResponseBody
	public LoginStatus getLoginStatus(Locale locale, final HttpServletRequest request, Model model)
	{
		LoginStatus status;
		if(request.getSession().getAttribute("loginStatus") != null)
		{
			status = (LoginStatus)request.getSession().getAttribute("loginStatus");
			
		}
		else
		{
			status = new LoginStatus(false,false, null, "Invalid session",null);
		}	
		return status;
	}

	
	
}

package com.aka.prototicket.controller.startup;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import com.aka.prototicket.controller.home.HomeController;

public class AppInitializer implements WebApplicationInitializer
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		
		logger.info("The application has started.");
	}

}

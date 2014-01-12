package com.aka.prototicket.controller.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import com.aka.prototicket.model.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/resources/app/", method = RequestMethod.GET)
	public String home(Locale locale,final HttpServletRequest request, Model model) {
		
		LoginStatus status = (LoginStatus)request.getSession().getAttribute("loginStatus");
		logger.info("Welcome to ProtoTicket! The client locale is {}. The username is {}", locale, status.getUsername());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "app";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public View root(Model model)
	{
		return new RedirectView("resources/app/");
	}
}

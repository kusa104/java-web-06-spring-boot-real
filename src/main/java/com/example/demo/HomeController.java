package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.security.SecurityUserDetails;

@Controller
public class HomeController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = { "/", "/home" })
	public String home(Model model, Authentication authentication) {
		logger.info("authentication : {}", authentication);
		SecurityUserDetails details = (SecurityUserDetails) 
			authentication.getPrincipal();
		model.addAttribute("details", details);
		return "/home";
	}
}

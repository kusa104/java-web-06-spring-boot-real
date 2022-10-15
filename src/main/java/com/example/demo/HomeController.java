package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/home")
	public void home() {
		logger.info("this is home");
	}
}

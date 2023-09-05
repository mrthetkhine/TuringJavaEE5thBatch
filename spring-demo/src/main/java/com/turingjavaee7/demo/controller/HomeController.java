package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.turingjavaee7.demo.service.ArithmeticService;
import com.turingjavaee7.demo.service.impl.ExampleBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	ArithmeticService arithService;
	
	@Autowired
	ExampleBean exampleBean;
	
	public HomeController() {
		log.info("Home Controller created");
	}
	
	@GetMapping("/")
	String home()
	{
		log.info("Get / "+ arithService.add(1, 2));
		return "home";
	}
	/*
	@GetMapping("/")
	String another()
	{
		log.info("Another / "+ arithService.add(1, 2));
		return "home";
	}*/
}

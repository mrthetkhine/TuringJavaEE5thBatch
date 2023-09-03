package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	String home()
	{
		System.out.println("Get /");
		return "home";
	}
}

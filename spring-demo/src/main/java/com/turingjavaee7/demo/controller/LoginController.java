package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String login() 
	{
		return "login"; 
	}
	
	@PostMapping
	public String loginSubmit(@RequestParam String username
							, @RequestParam String password)
	{
		log.info("login form post username "+username + " password "+password);
		return "redirect:/";
	}
}

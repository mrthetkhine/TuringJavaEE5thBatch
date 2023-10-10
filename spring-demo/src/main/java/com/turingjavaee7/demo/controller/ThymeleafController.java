package com.turingjavaee7.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/view")
public class ThymeleafController {
	
	@RequestMapping
	String index(Model model)
	{
		log.info("thmymeleaf index");
		model.addAttribute("message","Message from controller");
		
		List<String> cities = new ArrayList<String>();
		cities.add("Yangon");
		cities.add("Mandalay");
		cities.add("Bago");
		cities.add("Bagan");
		
		model.addAttribute("cities", cities);
		model.addAttribute("gender", "m");
		return "view";
	}
	@RequestMapping("/conditional")
	String conditional(Model model)
	{
		log.info("thmymeleaf conditional");
		model.addAttribute("message","Message from controller");
		
		List<String> cities = new ArrayList<String>();
		cities.add("Yangon");
		cities.add("Mandalay");
		cities.add("Bago");
		cities.add("Bagan");
		
		model.addAttribute("cities", cities);
		model.addAttribute("gender", "m");
		return "conditional";
	}
}

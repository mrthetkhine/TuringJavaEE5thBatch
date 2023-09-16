package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mvc")
public class MvcController {
	
	@GetMapping("/books/{id}")
	String booksById(Model model,@PathVariable String id)
	{
		model.addAttribute("message", "Book id "+id);
		return "hello";
	}
	@GetMapping("/books/search")
	String bookSearch(Model model,@RequestParam String title)
	{
		log.info("book search controller title="+title);
		model.addAttribute("message", "Book title "+title);
		return "hello";
	}
	
	@GetMapping("/hello")
	String hello(Model model)
	{
		log.info("Get hello controller");
		model.addAttribute("message", "Hello From Spring");
		return "hello";
	}
	@PostMapping("/hello")
	String helloPost(Model model)
	{
		log.info("post hello controller");
		model.addAttribute("message", "Hello From Spring");
		return "hello";
	}
}

package com.jspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/jsp")
@Slf4j
public class MvcJspController {

	@GetMapping
	String index()
	{
		log.info("/jsp GET");
		return "hello";
	}
}

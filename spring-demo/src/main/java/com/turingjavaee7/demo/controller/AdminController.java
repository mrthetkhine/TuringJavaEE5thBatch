package com.turingjavaee7.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turingjavaee7.demo.interceptor.LogInterceptor;
import com.turingjavaee7.demo.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	String admin(Model model)
	{
	
		return "/admin";
	}
}

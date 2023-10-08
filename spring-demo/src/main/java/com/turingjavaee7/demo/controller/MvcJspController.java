package com.turingjavaee7.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.JstlView;

import com.turingjavaee7.demo.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

@RequestMapping("/jsp")
public class MvcJspController {
	@GetMapping
	String index()
	{
	
		return "hello.jsp";
	}
	
}

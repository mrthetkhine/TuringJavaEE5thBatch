package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.turingjavaee7.demo.service.AuthenticationException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(AuthenticationException.class)
	public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception
	{
		log.info("Handle by gloabl auth exception");
		return "/error/403";
	}
}

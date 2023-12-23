package com.turing.jpa.demo.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turing.jpa.demo.model.dto.*;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.MovieService;


import jakarta.validation.Valid;

import  com.turing.jpa.demo.controller.rest.error.ApiErrorResponse;
import com.turing.jpa.demo.dao.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	
	
	@GetMapping
	String getAllMovies()
	{
		log.info("Hello Controller "+ Thread.currentThread().getName());
		return "Hello";
	}
	
}

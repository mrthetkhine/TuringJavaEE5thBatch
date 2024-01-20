package com.turing.mongo.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.dto.TodoDto;
import com.turing.mongo.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@GetMapping("/{todoId}")
	Mono<TodoDto> getTodo(@PathVariable String todoId)
	{
		return this.todoService.getTodoById(todoId);
	}
}

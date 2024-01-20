package com.turing.mongo.demo.controller.rest;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.dto.RestResponse;
import com.turing.mongo.demo.dto.TodoDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/dummy")
public class DummyApiController {
	
	@GetMapping("/500")
	Mono<ResponseEntity<TodoDto>> getTodo() throws Exception
	{
		TodoDto todo = new TodoDto(); 
		todo.setId("1");
		todo.setTitle("Task1 ");
		todo.setCompleted(false);
		
		ResponseEntity<TodoDto> response = ResponseEntity.ok(todo);
		
		//throw new Exception("Something went wrong");
		//return Mono.just(response);
		ResponseEntity<TodoDto> badRequest= ResponseEntity.status(HttpStatusCode.valueOf(404))
														.body(null);
		//return Mono.just(response);				
		return Mono.just(badRequest);
	}
}

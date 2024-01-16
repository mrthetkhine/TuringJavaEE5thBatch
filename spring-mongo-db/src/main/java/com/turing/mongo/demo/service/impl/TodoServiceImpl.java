package com.turing.mongo.demo.service.impl;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.turing.mongo.demo.controller.rest.MovieController;
import com.turing.mongo.demo.dto.TodoDto;
import com.turing.mongo.demo.service.TodoService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

	WebClient client ;
	
	@PostConstruct
	void init()
	{
		this.client = WebClient.builder()
				  .baseUrl("https://jsonplaceholder.typicode.com")
				  //.defaultCookie("cookieKey", "cookieValue")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  //.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				  .build();
	}
	@Override
	public Mono<TodoDto> getTodoById(Integer todoId) {
		return client.get()
			 .uri("/todos/"+todoId)	
			 .retrieve()
			 .bodyToMono(TodoDto.class);
		
	}

}

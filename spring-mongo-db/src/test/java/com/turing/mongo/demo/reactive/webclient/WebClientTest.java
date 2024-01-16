package com.turing.mongo.demo.reactive.webclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.turing.mongo.demo.service.TodoService;

import reactor.core.publisher.Mono;

import com.turing.mongo.demo.dto.*;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientTest {
	@Autowired
	TodoService todoService;
	
	@Test
	public void testGetTodo()
	{
		Mono<TodoDto> first = this.todoService.getTodoById(1);
		Mono<TodoDto> second = this.todoService.getTodoById(2);
		Mono.zip(first,second)
			.subscribe(data->{
				System.out.println(data);
			});
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

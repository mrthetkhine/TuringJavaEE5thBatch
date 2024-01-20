package com.turing.mongo.demo.service.impl;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.turing.mongo.demo.controller.rest.MovieController;
import com.turing.mongo.demo.dto.TodoDto;
import com.turing.mongo.demo.service.TodoService;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

	WebClient client ;
	
	@PostConstruct
	void init()
	{
		HttpClient httpClient = HttpClient.create()
				.doOnConnected(conn -> conn
						.addHandlerLast(new ReadTimeoutHandler(10))
						.addHandlerLast(new WriteTimeoutHandler(10)))
				//.responseTimeout(Duration.ofSeconds(10))
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
		this.client = WebClient.builder()
					.clientConnector(new ReactorClientHttpConnector(httpClient))
				  .baseUrl("https://jsonplaceholder.typicode.com")
				  //.defaultCookie("cookieKey", "cookieValue")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  //.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				  .build();
	}
	@Override
	public Mono<TodoDto> getTodoById(String todoId) {
		return client.get()
			 .uri("/todos/"+todoId)	
			 .retrieve()
			 .bodyToMono(TodoDto.class);
		
	}

}

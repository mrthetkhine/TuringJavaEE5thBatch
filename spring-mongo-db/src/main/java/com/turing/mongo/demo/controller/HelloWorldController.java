package com.turing.mongo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.scheduler.ScheduledTasks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	Mono<String> hello()
	{
		log.info("Hello controller "+Thread.currentThread().getName());
		return Mono.just("Hello")
					.map(data->data.toUpperCase());
	}
}

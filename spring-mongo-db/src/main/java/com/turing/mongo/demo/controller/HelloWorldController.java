package com.turing.mongo.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.scheduler.ScheduledTasks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
public class HelloWorldController {
	Scheduler s = Schedulers.boundedElastic();
	
	@Autowired
	MovieReactiveRepository repository;
	
	@GetMapping("/api/hello")
	Mono<String> hello()
	{
		log.info("Hello controller "+Thread.currentThread().getName());
		/*
		Flux<Movie> movies = this.repository.findAll();
		movies.subscribe(movie->{
			 System.out.println("Movie" +movie);
		 });
		 */
		return toCallable();
					
	}

	String getData()
	{
		try{
			//Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Hello";
	}
	private Mono<String> toCallable() {
		
		return Mono.fromCallable(()->getData())
					.publishOn(s);
	}
}

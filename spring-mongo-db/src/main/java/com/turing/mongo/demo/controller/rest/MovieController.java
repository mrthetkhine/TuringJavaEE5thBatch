package com.turing.mongo.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.controller.HelloWorldController;
import com.turing.mongo.demo.dto.MovieDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.turing.mongo.demo.model.*;
import com.turing.mongo.demo.service.MovieService;
@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@GetMapping
	Flux<MovieDto> getMovie()
	{
		log.info("getmovie controller");
		return this.movieService.getAllMovie();
	}
	@GetMapping("/{movieId}")
	Mono<ResponseEntity<Movie>> getMovieById(@PathVariable String movieId)
	{
		log.info("getmovie byid  "+movieId);
		return this.movieService.getMovieById(movieId)
								.map(movie->ResponseEntity.ok(movie))
								.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	@GetMapping("/year/{year}")
	Flux<Movie> findMovieByYear(@PathVariable Long year)
	{
		log.info("findMovieByYear controller");
		return this.movieService.getMovieByYear(year);
	}
}

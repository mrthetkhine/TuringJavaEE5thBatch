package com.turing.mongo.demo.service;
import com.turing.mongo.demo.dto.MovieDto;
import com.turing.mongo.demo.model.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface MovieService {
	Flux<MovieDto> getAllMovie();
	Mono<Movie> getMovieById(String id);
	Flux<Movie> getMovieByYear(Long year);
	Mono<Movie> saveMovie(MovieDto movieDto);
	Mono<MovieDto> updateMovieById(String movieId,MovieDto movieDto);
}

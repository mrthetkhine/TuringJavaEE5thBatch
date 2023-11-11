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
import com.turing.jpa.demo.service.MovieService;


import jakarta.validation.Valid;

import  com.turing.jpa.demo.controller.rest.error.ApiErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieApiController {

	@Autowired
	MovieService movieService;
	
	@GetMapping
	List<MovieDto> getAllMovies()
	{
		return this.movieService.getAllMovie();
	}
	
	@GetMapping("/year/{year}")
	List<MovieDto> getAllMovieByYear(@PathVariable Integer year)
	{
		return this.movieService.getAllMovieByYear(year);
	}
	@GetMapping("/title")
	List<MovieDto> getMovieByTitle(@RequestParam String title)
	{
		log.info("getByTitle controller");
		return this.movieService.getAllMovieTitle(title);
	}
	@GetMapping("/{movieId}")
	ResponseEntity<Object> getMovieById(@PathVariable Long movieId)
	{
		log.info("GET /api/movies/"+movieId);
		
		Optional<MovieDto> result = this.movieService.getMovieById(movieId);
		if(result.isPresent())
		{
			return ResponseEntity.ok(result.get());
		}
		else
		{
		
			ApiErrorResponse error = new ApiErrorResponse("1001", "No such movie with movieId "+movieId);
			return ResponseEntity.badRequest()
								 .body(error);
		}
	}
	@PostMapping
	ResponseEntity<Object> saveMovie(@RequestBody @Valid MovieDto movie,
									BindingResult result)
	{
		log.info("POST saveMovie "+movie);
		if(result.hasErrors())
		{
			log.info("Validation error in creating movie "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			MovieDto savedMovie = this.movieService.saveMovie(movie);
			return ResponseEntity.status(HttpStatus.CREATED)
								.body(savedMovie);
		}
	}
	@PutMapping("/{movieId}")
	ResponseEntity<Object> updateMovie(@PathVariable Long movieId,
			@RequestBody @Valid MovieDto movieDto,
									BindingResult result)
	{
		log.info("PUT updateMovie id "+movieId+"  "+movieDto);
		if(result.hasErrors())
		{
			log.info("Validation error in updating movie "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			MovieDto updatedMovie = this.movieService.updateMovie(movieDto);
			return ResponseEntity.ok()
								.body(updatedMovie);
		}
	}
	@DeleteMapping("/{movieId}")
	ResponseEntity<Object> deleteMovie(@PathVariable Long movieId)
	{
		log.info("Delete movie id "+movieId+"  ");
		try {
			this.movieService.deleteById(movieId);
			return ResponseEntity.ok()
					.body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest()
				 	.body(e);
		}
		
	}
}

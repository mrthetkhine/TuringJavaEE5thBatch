package com.turing.mongo.demo.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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


import com.turing.mongo.demo.controller.HelloWorldController;
import com.turing.mongo.demo.controller.rest.exception.BusinessException;
import com.turing.mongo.demo.dto.MovieDto;
import com.turing.mongo.demo.dto.RestResponse;
import com.turing.mongo.demo.dto.ReviewDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.turing.mongo.demo.model.*;
import com.turing.mongo.demo.service.MovieService;
import com.turing.mongo.demo.service.ReviewService;

import jakarta.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping
	Flux<MovieDto> getMovie()
	{
		log.info("getmovie controller");
		return this.movieService.getAllMovie();
	}
	@GetMapping("/directors/{rating}")
	Mono<ResponseEntity<RestResponse>> getDirectorWithAverageRatingGt(@PathVariable Integer rating)
	{
		log.info("directors/{rating}");
		return this.movieService.getDirectorNameWithAverageRatingGt(rating)
				.doOnNext(data->{
					System.out.println("Data "+data);
				})
				.collectList()
				.map(this::success);
	}
	@GetMapping("/{movieId}")
	Mono<ResponseEntity<Movie>> getMovieById(@PathVariable String movieId)
	{
		log.info("getmovie byid  "+movieId);
		return this.movieService.getMovieById(movieId)
								.map(movie->ResponseEntity.ok(movie))
								.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	@GetMapping("/{movieId}/reviews")
	Flux<ReviewDto> getAllReviewByMovieId(@PathVariable String movieId)
	{
		log.info("getAllReviewByMovieId controller");
		return this.reviewService.getAllReviewByMovieId(movieId);
	}
	@PostMapping("/{movieId}/reviews")
	Mono<ResponseEntity<RestResponse>> saveReview(@PathVariable String movieId,@Valid @RequestBody ReviewDto reviewDto)
	{
		log.info("saveReview controller");
		reviewDto.setMovieId(movieId);
		return this.reviewService.saveReviewForMovie(reviewDto)
								.map(review->success(review))
								.onErrorReturn(BusinessException.class, notFoundFallBack("Movie id not found"));
	}
	
	@PutMapping("/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> updateReview(
				@PathVariable String reviewId,
				@Valid @RequestBody ReviewDto reviewDto)
	{
		log.info("update reivew controller");
		reviewDto.setId(reviewId);
		return this.reviewService.updateReview(reviewDto)
								.map(review->success(review))
								//.onErrorReturn(BusinessException.class,  notFoundFallBack("Review not found"));
								.onErrorResume(BusinessException.class, (e)->{
									return Mono.just(notFoundFallBack(e.getMessage()));
								});
								
	}
	@DeleteMapping("/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> deleteReview(@PathVariable String reviewId)
	{
		log.info("deleteReview  controller");
	
		return this.reviewService.deleteReivewById(reviewId)
								.map(review->success(review))
								//.onErrorReturn(BusinessException.class,  notFoundFallBack("Review not found"));
								.onErrorResume(BusinessException.class, (e)->{
									return Mono.just(notFoundFallBack(e.getMessage()));
								});
								
	}
	@GetMapping("/year/{year}")
	Flux<Movie> findMovieByYear(@PathVariable Long year)
	{
		log.info("findMovieByYear controller");
		return this.movieService.getMovieByYear(year);
	}
	@GetMapping("/actor")
	Flux<MovieDto> findMovieByActor(@RequestParam String actor)
	{
		log.info("findMovieByActor controller");
		return this.movieService.getAllMovieByActor(actor);
	}
	@PostMapping
    public Mono<Movie> createMovie(@Valid @RequestBody MovieDto movieDto) {
		
		return this.movieService.saveMovie(movieDto);
    }
	
	ResponseEntity<RestResponse> notFoundFallBack(String message)
	{
		RestResponse response = new RestResponse();
		response.setError(message);
		return ResponseEntity
					.status(HttpStatusCode.valueOf(404))
					.body(response);
					
	}
	private ResponseEntity<RestResponse> success(Object data) {
		RestResponse response = new RestResponse();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}
	@PutMapping("/{id}")
    public Mono<ResponseEntity<RestResponse>> updateMovie(@PathVariable(value = "id") String movieId,
                                                   @Valid @RequestBody MovieDto movieDto) 
    {
		return this.movieService.updateMovieById(movieId, movieDto)
					.map(movie->success(movie))
					.onErrorReturn(BusinessException.class, notFoundFallBack("Movie not found"));
					
					
					
    }
	@DeleteMapping("/{id}")
    public Mono<ResponseEntity<RestResponse>> deleteMovie(@PathVariable(value = "id") String movieId) 
    {
		return this.movieService.deleteByMovieId(movieId)
					.map(movie->success(movie))
					.onErrorReturn(BusinessException.class, notFoundFallBack("Movie not found"));
					
					
    }
	
    
}

package com.turing.mongo.demo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.Review;

import reactor.core.publisher.Flux;

public interface ReviewRepository extends ReactiveMongoRepository<Review,String>{
	@Query("{ 'movie': ?0}")
	Flux<Review> findReviewByMovieId(String movie);
}

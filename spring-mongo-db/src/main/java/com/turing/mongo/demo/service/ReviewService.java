package com.turing.mongo.demo.service;
import com.turing.mongo.demo.dto.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface ReviewService {
	Flux<ReviewDto> getAllReviewByMovieId(String movieId);
	Mono<ReviewDto> saveReviewForMovie(ReviewDto reviewDto);
	Mono<ReviewDto> updateReview(ReviewDto reviewDto);
	Mono<ReviewDto> deleteReivewById(String reviewId);
	//Flux<String> getAllDirectorOfMovieWithAverageRatingGt(Integer rating);
}

package com.turing.mongo.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.mongo.demo.controller.rest.MovieController;
import com.turing.mongo.demo.controller.rest.exception.BusinessException;
import com.turing.mongo.demo.dto.ReviewDto;
import com.turing.mongo.demo.model.Review;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.repository.ReviewRepository;
import com.turing.mongo.demo.service.ReviewService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ReviewServieImpl implements ReviewService{
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MovieReactiveRepository movieRepository;

	ReviewDto entityToDto(Review review)
	{
		log.info("Review Id "+review.getId());
		ReviewDto dto = this.modelMapper.map(review, ReviewDto.class);
		dto.setMovieId(review.getMovie().getId());
		return dto;
	}
	Review dtoToEntity(ReviewDto reviewDto)
	{
		Review entity = this.modelMapper.map(reviewDto, Review.class);
		return entity;
	}
	@Override
	public Flux<ReviewDto> getAllReviewByMovieId(String movieId) {
		return this.reviewRepository.findReviewByMovieId(movieId)
					.map(this::entityToDto);
	}
	@Override
	public Mono<ReviewDto> saveReviewForMovie(ReviewDto reviewDto) {
		
		return this.movieRepository.findById(reviewDto.getMovieId())
							.switchIfEmpty(Mono.error(new BusinessException("Movie id not found")))
							.flatMap(movie->{
								Review review = this.dtoToEntity(reviewDto);
								review.setMovie(movie);
								return this.reviewRepository.save(review)
															.map(this::entityToDto);
							});

	}
	@Override
	public Mono<ReviewDto> updateReview(ReviewDto reviewDto) {
		return this.reviewRepository.findById(reviewDto.getId())
									.switchIfEmpty(Mono.error(new BusinessException("Review id >> not found")))	
									.flatMap(reviewEntity->{
										reviewEntity.setRating(reviewDto.getRating());
										reviewEntity.setReview(reviewDto.getReview());
										return this.reviewRepository.save(reviewEntity)
																	.map(this::entityToDto);
									});
	}
	@Override
	public Mono<ReviewDto> deleteReivewById(String reviewId) {
		
		return this.reviewRepository.findById(reviewId)
			  .switchIfEmpty(Mono.error(new BusinessException("Review id >> not found")))
			  .flatMap(review->{
				  return this.reviewRepository.delete(review)
				  		.thenReturn(review)
				  		.map(entity->this.entityToDto(entity));
			  });
	}

}

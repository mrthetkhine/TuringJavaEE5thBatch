package com.turing.mongo.demo.repository.movie;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.turing.mongo.demo.model.Review;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.repository.ReviewRepository;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DirectorOfMovieWithAverageRatingTest {
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MovieReactiveRepository movieRepository;

	/*
	 * -review group by movie
		->average
		-> movie
		-> name
*/
	@Test
	public void directorTest()
	{
		Integer rating = 4; 
		this.reviewRepository.findAll()
				.groupBy(review->review.getMovie().getId())
				.flatMap(group->{
					return group.collect(Collectors.averagingInt(Review::getRating))
								.map(averageRating->Tuples.of(group.key(), averageRating));
				})
				.filter(tuple-> tuple.getT2()>= rating)
				.flatMap(tuple->this.movieRepository.findById(tuple.getT1()))
				.map(movie->movie.getDirector())
				.distinct()
				.doOnNext(movie->{
					System.out.println("DoonNext>> movieId "+movie);
				})
				.subscribe();
				
	}
}

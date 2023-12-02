package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.MovieSpecification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class TestMovieSpecification {

	@Autowired
	MovieRepository movieRepository;
	
	int add(int a, int b)
	{
		return a+b;
	}
	@Test
	@Transactional
	public void testBetween()
	{
		//List<Movie> movies = this.movieRepository.findAll(MovieSpecification.getMovieByYear(2019L));
		//Specification<Movie> spec = MovieSpecification.getMovieByGenereOrYear("Drama",2023L);
		//Specification<Movie> spec = MovieSpecification.getMovieByTitle("Jhon Wick");
		
		//Specification<Movie> spec = MovieSpecification.getMovieNotGenere("Drama");
		
		List<String> genres = new ArrayList<>();
		genres.add("Drama");
		genres.add("Sci-Fi");
		//Specification<Movie> spec = MovieSpecification.getMovieInGenere(genres);
		//Specification<Movie> spec = MovieSpecification.getMovieWhereActorIn("Leonardo DiCaprio");
		Specification<Movie> spec = MovieSpecification.getMovieGroupByGenere("Sci-Fi");
		List<Movie> movies = this.movieRepository.findAll(spec);
		movies.forEach(System.err::println);
	}
}

package com.turing.jpa.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestMovieQBE {

	@Autowired
	MovieRepository movieRepository;
	
	
	@Test
	public void testMovieQBE()
	{
		log.info("Test case testMovieQBE");
		Movie movie = new Movie();
		movie.setYear(2010);
		
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<Movie> example = Example.of(movie, matcher);
		
		List<Movie> movies = this.movieRepository.findAll(example);
		
		movies.forEach(System.err::println);
	}
}

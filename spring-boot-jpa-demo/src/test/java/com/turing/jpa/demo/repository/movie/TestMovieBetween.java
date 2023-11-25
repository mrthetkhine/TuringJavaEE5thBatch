package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestMovieBetween {

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
		log.info("Test case testBetween");
		/*
		int result = add(1,2);
		
		assertEquals(3,result);
		*/
		/*
		Collection<Integer> years = new ArrayList<Integer>();
		years.add(1997);
		years.add(2010);
		List<Movie> movies = this.movieRepository.findAllByYearIn(years);
		for(Movie movie : movies)
		{
			System.err.println(movie.toString());
		}
		*/
		/*
		Movie movie = this.movieRepository.findTopByOrderByYearDesc();
		System.err.println(movie);
		*/
		List<Movie> movies = this.movieRepository.findAllMovieJPQL();
		movies.forEach(System.err::println);
	}
}

package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.dao.MovieSpecification;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;

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
		List<Movie> movies = this.movieRepository.findAll(MovieSpecification.getMovieByYear(2019L));
		movies.forEach(System.err::println);
	}
}

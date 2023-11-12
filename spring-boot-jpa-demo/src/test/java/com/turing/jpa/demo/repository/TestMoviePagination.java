package com.turing.jpa.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestMoviePagination {

	@Autowired
	MovieRepository movieRepository;
	
	
	@Test
	public void testPagination()
	{
		log.info("Test case testPagination");
	
		Page<Movie> pages = this.movieRepository.findAll(PageRequest.of(1, 5));
		pages.forEach(movie->{
			System.err.println(movie);
		});
	}
}

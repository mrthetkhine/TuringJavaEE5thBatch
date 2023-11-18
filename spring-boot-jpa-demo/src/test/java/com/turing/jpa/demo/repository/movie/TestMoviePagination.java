package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
	
		Sort.TypedSort<Movie> sort = Sort.sort(Movie.class);
		
		/*
		Page<Movie> pages = this.movieRepository.findAll(PageRequest.of(1, 5),
						);
		pages.forEach(movie->{
			System.err.println(movie);
		});
		*/
		List<Movie> movies = this.movieRepository.findAll(sort.by(Movie::getYear).descending());
		movies.forEach(movie->System.err.println(movie));
	}
}

package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.model.entity.MovieDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestUpdateMovie {

	@Autowired
	MovieRepository movieRepository;
	
	int add(int a, int b)
	{
		return a+b;
	}
	@Transactional
	@Test
	public void testUpdateMovie()
	{
		log.info("Test case testUpdateMovie");
		/*
		int row = this.movieRepository.updateYearByMovieId(10L, 2010);
		*/
		try
		{
			Movie movie = this.movieRepository.getById(1L);
			System.out.println("Movie "+movie.getTitle());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//this.movieRepository.delete(movie);
		//System.out.println("Row "+row);
		
		/*
		Movie movie = new Movie();
		movie.setTitle("Testing 4");
		
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setDetails("Movie Testing 4 Details");
		
		movie.setMovieDetails(movieDetails);
		movieDetails.setMovie(movie);
		
		this.movieRepository.save(movie);
		*/
	}
}

package com.turing.jpa.demo.repository.movie.transaction;

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
import com.turing.jpa.demo.service.TransactionDemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SaveMovieByHibernateSession {

	@Autowired
	TransactionDemoService transactionService;
	
	int add(int a, int b)
	{
		return a+b;
	}
	@Transactional
	@Test
	public void testUpdateMovie()
	{
		
		
		Movie movie = new Movie();
		movie.setTitle("Testing movie 3 for transaction");
		
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setDetails("Movie Testing 3 Details");
		
		movie.setMovieDetails(movieDetails);
		movieDetails.setMovie(movie);
		
		this.transactionService.saveMovie(movie);
	}
}

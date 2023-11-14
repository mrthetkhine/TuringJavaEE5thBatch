package com.turing.jpa.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieCustomQuery {

	@Autowired
	MovieRepository movieRepository;
	
	int add(int a, int b)
	{
		return a+b;
	}
	@Test
	public void testCustomQuery()
	{
		log.info("Test case testCustomQuery");
		List<String> genres = this.movieRepository.getAllGeneres();
		genres.forEach(genre->System.err.println(genre));
		
		/*
		
		int totalDrama = this.movieRepository.findTotalMovieByGenres("Action");
		System.err.println("Total no of drama "+totalDrama);
		
		List<Movie> movies = this.movieRepository.findAllMovie();
		movies.forEach(movie->System.err.println(movie));
		*/
		//List<GenreCountDto> genres = this.movieRepository.getAllGeneresCount();
		/*
		try
		{
			List<GenreCountDtoTwo> genres = this.movieRepository.getAllGeneresCountTwo();
			genres.forEach(genre->System.err.println("Genere "+genre.getGenre()+" Count "+genre.getCount())
					);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
	}
}

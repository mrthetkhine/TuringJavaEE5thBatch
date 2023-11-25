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
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Comment;
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
	@Transactional
	public void testCustomQuery()
	{
		log.info("Test case testCustomQuery");
		/*
		try
		{
			//
			Optional<Movie> result = this.movieRepository.findById(1L);
			Movie movie = result.get();
			System.out.println("Movie title"+movie.getTitle());
			System.out.println("Comments ");
			List<Comment> comments = movie.getComments();
			
			comments.forEach(System.err::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		List<Movie> movies = this.movieRepository.findAllMovie();
		movies.forEach(movie->System.err.println(movie));
		//List<String> genres = this.movieRepository.getAllGeneres();
		//genres.forEach(genre->System.err.println(genre));
		
		/*
		
		int totalDrama = this.movieRepository.findTotalMovieByGenres("Action");
		System.err.println("Total no of drama "+totalDrama);
		
		
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

package com.turing.jpa.demo.repository.movie.querydsl;

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

import com.querydsl.core.Tuple;
import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieDao;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.MovieSpecification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class TestQueryDSL {

	@Autowired
	MovieDao movieDao;
	
	@Test
	@Transactional
	public void testQueryDSL()
	{
		//List<Movie> movies = this.movieDao.getAllMovieByYear(2019);
		//List<Movie> movies = this.movieDao.getAllMovieByYearOrGene(2019,"Sci-Fi");
		//movies.forEach(System.err::println);
		//List<Tuple> genreAndCounts = this.movieDao.getGenreAndCount();
		//genreAndCounts.forEach(System.err::println);
		
		List<String> genres = new ArrayList<>();
		genres.add("Sci-Fi");
		genres.add("Drama");
		
		//List<Movie> movies = this.movieDao.getAllMovieWhereGenresIn(genres);
		//List<Movie> movies = this.movieDao.getAllMovieActoredBy("Leonardo DiCaprio");
		//movies.forEach(System.err::println);
		
		//this.movieDao.deleteMovieById(27L);
		this.movieDao.updateTitleById("Test Update", 24L);
	}
	
}

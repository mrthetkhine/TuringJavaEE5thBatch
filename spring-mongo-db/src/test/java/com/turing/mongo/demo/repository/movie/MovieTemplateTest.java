package com.turing.mongo.demo.repository.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieDao;
import com.turing.mongo.demo.repository.MovieRepository;

@SpringBootTest
class MovieTemplateTest {

	 @Autowired 
	 MovieDao movieDao;
	
	 
	 @Test
	 void testMovieCRUD() {
		 
		 int year = 2009;
		 System.out.println("Year in test "+year);
		 List<Movie> movies = this.movieDao.getAllMovieInYear(year);
		 movies.forEach(System.err::println);
		 
	 }
	 
	

}

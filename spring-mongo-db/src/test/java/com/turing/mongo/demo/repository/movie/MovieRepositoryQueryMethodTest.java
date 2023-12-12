package com.turing.mongo.demo.repository.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieRepository;

@SpringBootTest
class MovieRepositoryQueryMethodTest {

	 @Autowired 
	 MovieRepository movieRepository;
	 
	 @Autowired 
	 ActorRepository actorRepository;
	
	 @Test
	 public void testQueryMethod()
	 {
		 List<Movie> movies = this.movieRepository.findMovieWhereGeneresIs("Sci-Fi");
		 //List<Movie> movies = this.movieRepository.findByActors_FirstName("Leonardo");
		 movies.forEach(System.err::println);		 
	 }

}

package com.turing.mongo.demo.repository.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Streamable;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.model.QMovie;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieDao;
import com.turing.mongo.demo.repository.MovieQueryDSLRepository;
import com.turing.mongo.demo.repository.MovieRepository;

//@SpringBootTest
//@Testcontainers
@DataMongoTest
class MovieQueryDSLTest {

	 @Autowired 
	 MovieQueryDSLRepository movieRepository;
	
	 
	 @Test
	 void testMovieCRUD() {
		 
		 System.out.println("RunTest");
		 Iterable<Movie> result = movieRepository.findAll(QMovie.movie.name.startsWith("Movie"));
		 List<Movie> movies= Streamable.of(result).toList();
		 movies.forEach(System.err::println);
	 }
	 
	

}

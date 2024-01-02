package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.util.Streamable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.model.QMovie;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieDao;
import com.turing.mongo.demo.repository.MovieQueryDSLRepository;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReduceTest {

	 @Autowired
	 MovieReactiveRepository repository;
	 
	 
	 @Test
	 void testReduce()
	 {
		 Flux<Integer> range = Flux.range(0, 11);
		 range.reduce((a,b)->a+b)
		 	  .subscribe(total->{
		 		  System.out.println("Total is "+total);
		 	  });
	 }
	 @Test
	 void testMongoReactiveRepository()
	 {
		 
		
		 Flux<Movie> movies = this.repository.findAll();
		 movies.reduce((movieA,movieB)->{
			 return movieA.getYear() < movieB.getYear()?movieA:movieB;
		 })
		 .subscribe(movie->{
			 System.out.println("Oldest movie "+movie);
		 });
	 }
	 
	 
}

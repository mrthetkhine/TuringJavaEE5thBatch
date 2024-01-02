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
class CollectMapTest {

	 @Autowired
	 MovieReactiveRepository repository;
	 
	 
	
	 @Test
	 void testMongoReactiveRepository()
	 {
		 
		
		 Flux<Movie> movies = this.repository.findAll();
		 Mono<Map<String,Integer>> map= movies.filter(movie->movie.getActors().size()>=2)
		 		//.map(movie->movie.getDirector())//Flux<String>
		 		.collectMap(movie->movie.getId(),movie->movie.getActors().size());
		 		//.subscribe(System.err::println);
		 map.subscribe(data->{
			data.forEach((key,value)->{
				System.out.println("Key "+key+ " Value "+value);
			});
		 });
	 }
	 
	 @Test
	 void testCount()
	 {
		 
		
		 Flux<Movie> movies = this.repository.findAll();
		 movies.count()
		 		.subscribe(movieCount->{
		 			System.out.println("Movie count "+movieCount);
		 		});
	 }
	
}

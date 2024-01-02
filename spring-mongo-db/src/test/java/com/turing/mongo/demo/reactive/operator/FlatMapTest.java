package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
class FlatMapTest {

	 @Autowired
	 MovieReactiveRepository repository;
	 
	 Mono<String> titleToMono(String title)
	 {
		 return Mono.just(title);
	 }
	 @Test
	 void testMongoReactiveRepository()
	 {
	
		 Flux<Movie> movies = this.repository.findAll();
		 /*
		 Flux<Mono<String>> list = movies.map(movie->titleToMono(movie.getName()));
		 
		 list.subscribe(data->{
			 data.subscribe(str->{
				 System.out.println("Data "+str); 
			 });	
		 });
		 */
		 Flux<String> ids = movies.map(movie->movie.getId());
		 Flux<Mono<Movie>> movieByIds = ids.map(id->this.repository.findById(id));
		 Flux<Movie> movieByIdsTwo = ids.flatMap(id->this.repository.findById(id));
		 movieByIdsTwo.subscribe(movie->{
			System.out.println(movie); 
		 });
	 }
	 
	

}

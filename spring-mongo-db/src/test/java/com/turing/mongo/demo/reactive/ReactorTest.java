package com.turing.mongo.demo.reactive;

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


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReactorTest {

	 @Autowired
	 MovieReactiveRepository repository;
	 
	 /*
	 @Test
	 void testReactor() {
		 
		 Flux<Integer> rangeOfIntegers = Flux.range(0, 10);
		 rangeOfIntegers.subscribe(item->{
			 System.out.println("Item "+item);
		 });
		 
		 System.out.println("End");
		 //StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete();
	 }
	 @Test
	 void testJust()
	 {
		 Flux<String> letters = Flux.just("A", "B", "C");
		 StepVerifier.create(letters)
		 			 .expectNext("A", "B", "C")
		 			 .verifyComplete();
		 long now = System.currentTimeMillis();
	     Mono<Date> greetingMono = Mono.just(new Date(now));
	     greetingMono.subscribe(data->{
	    	 System.out.println("Data "+data);
	     });
	     greetingMono.subscribe(data->{
	    	 System.out.println("Data2 "+data);
	     });
	     StepVerifier.create(greetingMono)
	     			.expectNext(new Date(now))
	     			.verifyComplete();
	 }
	 */
	 @Test
	 void testMongoReactiveRepository()
	 {
		 
		 Flux<Movie> movies = this.repository.findAll();
		 movies
		 	.map(movie->movie.getName())
		 	.subscribe(movie->{
			 System.out.println("Movie" +movie);
		 });
		 System.out.println("End of code");
		 
	 }
	 
	

}

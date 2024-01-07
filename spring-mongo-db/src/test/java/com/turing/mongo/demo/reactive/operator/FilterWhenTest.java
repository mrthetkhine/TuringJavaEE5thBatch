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


//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FilterWhenTest {

	 Mono<Boolean> isOdd(Integer data)
	 {
		 return Mono.just(data%2!=0);
	 }
	 @Test
	 void testFilterWhen()
	 {
		 Flux.just(1,2,3,4,5)
		 	 .filterWhen(this::isOdd)	
		 	 .subscribe(System.err::println);
	 }
	 @Test
	 void testFilterType()
	 {
		 Flux<Object> all = Flux.just("Hello",122,"Data");
		 all.ofType(String.class)
		 	.doOnNext((item)->{
		 		System.out.println("item "+item);
		 	})
		 	.ignoreElements()
		 	.subscribe(System.err::println);
	 }
	 /*
	 @Test
	 void testDistinct()
	 {
		 Flux<Integer> data = Flux.just(1,2,3,1,2,2);
		 	data.distinct()
		 		.take(2)
		 		.collectList()
		 		.subscribe(item->{
		 			System.out.println("NonDuplicate "+item);
		 		});
	 }
	 */
	 /*
	 @Test
	 void testTakeOnTime()
	 {
		 Flux<Integer> data = Flux.just(1,2,3,1,2,2)
				 					.delayElements(Duration.ofSeconds(1));
		 	data.distinct()
		 		.take(Duration.ofSeconds(2))
		 		.collectList()
		 		.subscribe(item->{
		 			System.out.println("NonDuplicate "+item);
		 		});
		 	try
		 	{
		 		Thread.sleep(8000);
		 	}
		 	catch(Exception e)
		 	{
		 		e.printStackTrace();
		 	}
	 }*/
	 /*
	 @Test
	 void testTakeLast()
	 {
		 Flux.just(1,2,3,1,2,5)
		 		.takeLast(2)
		 		.subscribe(item->{
		 			System.out.println("Last "+item);
		 		});
	 }
	 */
	 /*
	 @Test
	 void testTakeUntil()
	 {
		 Flux.just(1,2,5,3,4,5,1,2,5)
		 		.takeUntil(item->item==5)
		 		.subscribe(item->{
		 			System.out.println("Take Until "+item);
		 		});
	 }
	 */
	 @Test
	 void testTakeWhile()
	 {
		 Flux.just(1,2,5,3,4,5,1,2,5)
		 		.takeWhile(item->item < 5)
		 		.subscribe(item->{
		 			System.out.println("Take While "+item);
		 		});
	 }
}

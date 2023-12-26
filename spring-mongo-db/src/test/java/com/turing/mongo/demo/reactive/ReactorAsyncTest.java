package com.turing.mongo.demo.reactive;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
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
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

//@SpringBootTest
//@Testcontainers
@DataMongoTest
//@ExtendWith(SpringExtension.class)

class ReactorAsyncTest {

	private final ExecutorService executorService = Executors.newFixedThreadPool(1);

	@Test
	void testInterval()
	{
		Flux.interval(Duration.ofMillis(1000))
								//.take(10)
				                .subscribe(data->{
				                	System.out.println("Data from interval "+data);
				                });
		
	}
	@Test
	void testReactor() {

		Flux<Integer> integers = Flux.create(emitter -> this.launch(emitter, 5));
		integers.subscribe(data->{
			System.out.println("Data "+data +" Thread"+Thread.currentThread().getName());
		});

		System.out.println("End");
		// StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete();
		
	}

	private void launch(FluxSink<Integer> integerFluxSink, int count) {
		this.executorService.submit(() -> {
			var integer = new AtomicInteger();

			while (integer.get() < count) {
				double random = Math.random();
				integerFluxSink.next(integer.incrementAndGet());
				this.sleep((long) (random * 1000));
			}
			integerFluxSink.complete();
		});
	}

	private void sleep(long s) {
		System.out.println("Thread "+Thread.currentThread().getName());
		try {
			Thread.sleep(s);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}

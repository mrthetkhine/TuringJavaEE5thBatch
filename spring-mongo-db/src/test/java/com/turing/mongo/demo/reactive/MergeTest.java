package com.turing.mongo.demo.reactive;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MergeTest {
	@Test
	void testMerge()
	{
		Flux<String> one = Flux.just("1","2","3")
							.delayElements(Duration.ofMillis(200));
		Flux<String> two = Flux.just("One","Two","Three")
				.delayElements(Duration.ofMillis(100));
		Flux<Pair<String,String>> result = Flux.zip(
			      one, 
			      two, 
			      (a, b) ->Pair.of(a,b));
		
		result.subscribe(item->{
			System.out.println("Data "+item.getFirst()+" second "+item.getSecond());
		});
		
		StepVerifier.create(one)
	      .expectNext("1")
	      .expectNext("2")
	      .expectNext("3")
	      .expectComplete()
	      .verify();
	}
}

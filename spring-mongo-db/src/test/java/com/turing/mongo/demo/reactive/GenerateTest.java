package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class GenerateTest {
	@Test
	void testGenerate()
	{
		Flux<String> result = Flux.generate(()->0,
				(state, sink) -> {
				      sink.next("3 x " + state + " = " + 3*state); 
				      if (state == 10) sink.complete(); 
				      return state + 1; 
				    });
		result.subscribe(data->{
			System.out.println("Data "+data);
		});
	}
}

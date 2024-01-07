package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class DeferTest {
	Flux<String> syncFunction()
	{
		System.out.println("Syncfunction");
		return Flux.just("Result");
	}
	@Test
	public void testDefer()
	{
		Flux.defer(()->syncFunction())
			.subscribe(data->{
				System.out.println("Data "+data);
			});
			
	}
}

package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class ElementAtTest {
	
	@Test
	public void takeNthTest()
	{
		Flux<Integer> data = Flux.just(1,2,3,4);
			data.elementAt(2)
				.subscribe(System.err::println);
	}
	@Test
	public void skipTest()
	{
		Flux<Integer> data = Flux.just(1,2,3,4);
			data.skip(2)
				.subscribe(item->{
					System.out.println("Skip "+item);
				});
	}
}

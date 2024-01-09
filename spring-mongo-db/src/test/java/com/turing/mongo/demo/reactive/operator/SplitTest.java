package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SplitTest {
	@Test
	public void testAnd()
	{
		//0,1,2,3..10
		//[0,1],[2,3]
		//Flux<Integer> data = Flux.range(0, 11);
		Flux<Integer> data = Flux.range(0, 11);
		Flux<Flux<Integer>> window = data.window(3);
		window.flatMap(item->item.collectList())
				.subscribe(System.out::println);
		
	}
}

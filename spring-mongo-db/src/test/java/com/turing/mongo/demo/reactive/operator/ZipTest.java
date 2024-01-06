package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public class ZipTest {
	@Test
	public void testZip()
	{
		Flux<String> one = Flux.just("apple","orange","banana");
		Flux<Integer> two = Flux.just(1,2,3,4,5);
		
		Flux<Tuple2<String,Integer>> result = Flux.zip(one,two);
		result.subscribe(data->{
			System.out.println("First "+data.getT1()+" Second "+data.getT2());
		});
	
	}
}

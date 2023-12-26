package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class SubscribeTest {

	Flux<String> getData()
	{
		System.out.println("Method called");
		return Flux.just("hello","null")
				   .map(data->{
					   System.out.println("Transform");
					   return data.toUpperCase();
				   });
	}
	@Test
	void testSubscribe()
	{
		getData()
			.subscribe(data->{
				System.out.println("Data is "+data);
			},error->{
				System.err.println("Error "+error.getMessage());
			},()->{
				System.out.println("Done");
			});
	}
}

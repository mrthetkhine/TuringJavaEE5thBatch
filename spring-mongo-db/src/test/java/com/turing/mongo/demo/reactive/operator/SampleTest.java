package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class SampleTest {
	
	@Test
	public void sampleTest()
	{
		Flux<Integer> one = Flux.just(1,2,3,4)
								.delayElements(Duration.ofMillis(200));
		Flux<Integer> two = Flux.just(10,20,30,40)
				.delayElements(Duration.ofMillis(100));
		Flux<Integer> result = Flux.merge(one,two);
		result
			.sample(Duration.ofMillis(200))
			.subscribe(item->{
			System.out.println("Item "+item);
		});
		
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

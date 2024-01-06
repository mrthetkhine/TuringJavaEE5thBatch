package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class ZipWithTest {
	@Test
	public void testZipWith()
	{
		Flux<Integer> one = Flux.just(1,2,3,4)
								.delayElements(Duration.ofMillis(500));
		Flux<String> two = Flux.just("apple","orange","banana");
		
		Flux<String> result = one.zipWith(two,(a,b)->{
			return b.repeat(a);
		});
		result.subscribe(System.out::println);
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

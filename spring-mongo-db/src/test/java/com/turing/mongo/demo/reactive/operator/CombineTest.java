package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CombineTest {
	
	@Test
	public void testConcat()
	{
		Flux<Integer> first = Flux.just(1,2,3)
								   .delayElements(Duration.ofSeconds(1));	
		Flux<Integer> second = Flux.just(10,20,30)	
								 	.delayElements(Duration.ofMillis(500));
		//Flux<Integer> result = Flux.concat(first,second);
		Flux<Integer> result = Flux.merge(first,second);
		result.subscribe(data->{
				System.out.println(data);
			});
		
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

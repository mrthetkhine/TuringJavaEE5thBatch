package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class SingleTest {
	
	@Test
	public void sampleTest()
	{
		//Flux<Integer> one = Flux.just(1);
		Flux<Integer> one = Flux.empty();
		//one.single()
		one.singleOrEmpty()
			.subscribe(data->{
				System.out.println("Data "+data);
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

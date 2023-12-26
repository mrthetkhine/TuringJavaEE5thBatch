package com.turing.mongo.demo.reactive;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class IntervalTest {

	@Test
	void testInterval()
	{
		Flux<Long> integers = Flux.interval(Duration.ofMillis(500));
		integers.subscribe(data->{
			System.out.println("Data "+data);
		});
		Flux<Long> another = Flux.interval(Duration.ofMillis(700));
		another.subscribe(data->{
			System.out.println("Data>> "+data);
		});
		
		try
		{
			Thread.sleep(30000);
		}
		catch(Exception e)
		{
			
		}
	}
}

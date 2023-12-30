package com.turing.mongo.demo.reactive;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class RetryTest {
	@Test
	public void testRetry()
	{
		Flux.interval(Duration.ofMillis(250))
	    .map(input -> {
	        if (input < 3) return "tick " + input;
	        throw new RuntimeException("boom");
	    })
	    .retry(1)
	    .elapsed() 
	    .subscribe(System.out::println, System.err::println); 

		try
		{
			Thread.sleep(2100);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

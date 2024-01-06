package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WhenTest {
	/*
	@Test
	public void testWhen()
	{
		Mono<String> first =Mono.just("Hello")
							.delayElement(Duration.ofSeconds(1));
		Mono<String> second =Mono.just("World")
				.delayElement(Duration.ofSeconds(2));
		Mono.when(first,second)
			.then(Mono.just("result"))
			.subscribe((data)->{
				System.out.println("Done "+data);
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
	*/
	@Test
	public void testFirstWith()
	{
		Flux<String> one =Flux.just("Hello","How")
							.delayElements(Duration.ofSeconds(1));
		
		one.firstWithValue(item->{
			System.out.println("first "+item);
		}).subscribe();
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

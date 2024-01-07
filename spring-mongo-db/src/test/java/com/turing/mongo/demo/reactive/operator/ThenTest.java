package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.awaitility.Durations;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public class ThenTest {

	Flux<String> another()
	{
		System.out.println("Executed another");
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return Flux.just("Another");
				
	}
	Mono<String> second()
	{
		System.out.println("Executed second");
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return Mono.just("second");
				
	}
	/*
	@Test
	public void testThen()
	{
		
		Flux<String> one = Flux.just("apple","orange","banana")
								.delayElements(Duration.ofSeconds(1));
		another().then(second())
			.then()
			.doOnNext(item->{
				System.out.println("Item "+item);
			})
			.doFinally(signal->{
				System.out.println("Finally");
			})
			.subscribe(data->{
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
	*/
	/*
	@Test
	public void testThenReturn()
	{
		second()
			.thenReturn("Hello")
			.subscribe(data->{
				System.out.println("Data "+data);
			});
	}
	@Test
	public void testThenMany()
	{
		Flux<String> many = Flux.just("Hello","world");
		second()
			.thenMany(many)
			.subscribe(data->{
				System.out.println("Data "+data);
			});
		
	}
	*/
	@Test
	public void testThenManyFlux()
	{
		Flux<String> many = Flux.just("Hello","world")
							.delayElements(Duration.ofMillis(500));
		many.map(item->{
			System.out.println("Item "+item);
			return item.toUpperCase();
		})
		.map(item->{
			System.out.println("Uppercase "+item);
			return item;
		})
		.then(Mono.just("Completed"))
		.subscribe(date->{
			System.out.println("Completed");
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

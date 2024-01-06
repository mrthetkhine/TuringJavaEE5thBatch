package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class DefaultIfEmptyTest {

	Mono<Integer> div(int a,int b)
	{
		if(b ==0)
		{
			return Mono.empty();
		}
		else
		{
			return Mono.just(a/b);
		}
	}
	Mono<Integer> fallBack()
	{
		return Mono.just(100)
					.delayElement(Duration.ofSeconds(5));
	}
	@Test
	public void testDefaultIfEmpty()
	{
		div(10,2)
			//.defaultIfEmpty(0)
			.switchIfEmpty(fallBack())
			.subscribe(item->{
				System.out.println("Result "+item);
			});
	}
}

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
	@Test
	public void testZip()
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
}

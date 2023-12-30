package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

public class PublishOnTest {
	Scheduler s = Schedulers.boundedElastic();
	int getData(int i)
	{
		try
		{
			Thread.sleep(5000);
			System.out.println("Thread "+Thread.currentThread().getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i*200;
	}
	@Test
	void testBlockingCall()
	{
		
		Mono<Integer> result = Mono.fromCallable(()->getData(10));
		result.publishOn(s)
			.subscribe(data->{
				System.out.println("Threadname "+Thread.currentThread().getName());
				System.out.println("Data "+data);
			});
		StepVerifier //
        .create(result)//
        .expectNext(2000)
        .verifyComplete();
				
	}
	/*
	@Test
	void testPublishOn()
	{
		Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
		final Flux<String> flux = Flux
			    .range(1, 2)
			    .map(i -> 10 + i)  
			    .publishOn(s)  
			    //.subscribeOn(s)
			    .map(i -> "value "+Thread.currentThread().getName()+"=>" + i);  
		flux.subscribe(data->{
			System.out.println("Data "+Thread.currentThread().getName()+" "+data);
		});
			//new Thread(() -> flux.subscribe(System.out::println));
	}*/
}

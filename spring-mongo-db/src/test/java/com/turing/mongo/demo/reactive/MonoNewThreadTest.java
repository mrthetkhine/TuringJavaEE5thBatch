package com.turing.mongo.demo.reactive;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoNewThreadTest {
	/*
	@Test
	void testMonoNewThread() throws InterruptedException
	{
		final Mono<String> mono = Mono.just("hello "); 

		  Thread t = new Thread(() -> mono
		      .map(msg -> msg + "thread ")
		      .subscribe(v -> 
		          System.out.println(v + Thread.currentThread().getName()) 
		      )
		  );
		  t.start();
		  t.join();
	}*/
	@Test
	void testRunOnSeperateThread()
	{
		Flux.interval(Duration.ofMillis(300), Schedulers.newSingle("test"))
			.subscribe(data->{
				System.out.println(data+" "+Thread.currentThread().getName());
			});
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

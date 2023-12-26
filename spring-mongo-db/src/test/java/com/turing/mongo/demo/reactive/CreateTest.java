package com.turing.mongo.demo.reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.test.StepVerifier;

public class CreateTest {

	void syncMethod(FluxSink<Integer> sink)
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Runnable runnableTask = () -> {
			try
			{
				System.out.println("Start task");
				Thread.sleep(5000);
				System.out.println("Done computation complete");
				sink.next(100);
				sink.complete();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		};
		executor.execute(runnableTask);
		
	}
	@Test
	void testCreate()
	{
		Flux<Integer> result = Flux.create(sink->{
			syncMethod(sink);
			/*
			sink.next(1);
			sink.next(2);
			sink.complete();
			*/
		});
		
		result.subscribe(data->{
			System.out.println(data);
		});
		StepVerifier.create(result)
	      .expectNext(100)
	      .expectComplete()
	      .verify();
	}
}

package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public class RepeatTest {
	static int count = 0;
	boolean shouldRepeat()
	{
		RepeatTest.count ++;
		return count<10;
	}
	@Test
	public void testZip()
	{
		final int count =0;
		Flux<String> one = Flux.just("apple","orange","banana");
		//one.repeat()
		//one.repeat(4)
		one.repeat(this::shouldRepeat)
			.subscribe(item->{
				System.out.println(item);
			});
	
	}
}

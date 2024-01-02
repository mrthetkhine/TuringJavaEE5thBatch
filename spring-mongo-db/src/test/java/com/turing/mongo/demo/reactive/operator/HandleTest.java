package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class HandleTest {
	@Test
	public void testHandle()
	{
		Flux.range(1, 20)
        .handle((integer, synchronousSink) -> {
            if(integer == 9)
                synchronousSink.complete();
            else
                synchronousSink.next(integer);
        })
        .subscribe(System.err::println);

	}
}

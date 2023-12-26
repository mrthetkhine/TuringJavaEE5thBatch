package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class MapFilterTest {
	@Test
	void testMapFilter()
	{
		Flux.just("hello","hi","how are you")
			.map(str->str.length())
			.filter(len->len>2)
			.subscribe(data->{
				System.out.println("Length "+data);
			});
	}
}

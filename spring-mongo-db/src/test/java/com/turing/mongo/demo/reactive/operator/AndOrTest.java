package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AndOrTest {
	@Test
	public void testAnd()
	{
		Flux<Integer> data = Flux.range(0, 11);
		Mono<Boolean> result = data.any(item->item>0);
		result.subscribe(output->{
			System.out.println("Output "+output);
		});
		data.hasElement(4)
			.subscribe(output->{
				System.out.println("Yes there is 4");
			});
	}
}

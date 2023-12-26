package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class HandleTest {
	public String alphabet(int letterNumber) {
		if (letterNumber < 1 || letterNumber > 26) {
			return null;
		}
		int letterIndexAscii = 'A' + letterNumber - 1;
		return "" + (char) letterIndexAscii;
	}
	@Test
	void testHandle()
	{
		Flux<String> alphabet = Flux.just(-1, 30, 13, 9, 20)
			    .handle((i, sink) -> {
			        String letter = alphabet(i); 
			        if (letter != null) 
			            sink.next(letter); 
			    });

		alphabet.subscribe(System.out::println);
	}
}

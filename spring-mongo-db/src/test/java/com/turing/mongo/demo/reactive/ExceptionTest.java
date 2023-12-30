package com.turing.mongo.demo.reactive;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExceptionTest {
	
	int div(int a, int b)
	{
		if(b==0)
		{
			throw new RuntimeException("Division by zero");
		}
		else
		{
			return a/b;
		}
	}
	Mono<Integer> reactiveDiv(int a,int b)
	{
		if(b==0)
		{
			Exception ex= new Exception("Division by zero");
			return Mono.error(ex);
		}
		else
		{
			return Mono.just(a/b);
		}
	}
	@Test
	void testDiv()
	{
		reactiveDiv(10,0)
			.subscribe(data->{
				System.out.println("Success "+data);
			},err->{
				System.err.println("Error "+err.getMessage());	
			});
	}
	public String convert(int i) throws IOException {
	    if (i > 3) {
	        throw new IOException("boom " + i);
	    }
	    return "OK " + i;
	}
	@Test 
	void testPropgation()
	{
		Flux<String> converted = Flux
			    .range(1, 10)
			    .map(i -> {
			        try { return convert(i); }
			        catch (IOException e) { 
			        	throw Exceptions.propagate(e); 
			        	//throw e;
			        }
			    });
		converted.subscribe(
			    v -> System.out.println("RECEIVED: " + v),
			    e -> {
			        if (Exceptions.unwrap(e) instanceof IOException) {
			            System.out.println("Something bad happened with I/O");
			        } else {
			            System.out.println("Something bad happened");
			        }
			    }
			);
	}
}

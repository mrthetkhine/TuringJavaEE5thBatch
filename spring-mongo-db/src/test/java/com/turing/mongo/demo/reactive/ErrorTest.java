package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorTest {
	Mono<String> getUserNameById(int i)
	{
		if(i==0)
		{
			return Mono.empty();
		}
		else
		{
			return Mono.just("Username");
		}
	}
	@Test 
	public void testEmpty()
	{
		this.getUserNameById(10)
			.subscribe(data->{
				System.out.println("Data "+data);
			});
	}
	
	@Test
	public void testError()
	{
		Flux<String> strings = Flux.just("Hello",null,"Another","Hello","world");
		strings.map(data->data.length())
				//.onErrorReturn((err)->err instanceof NullPointerException,0)
				//.onErrorReturn((err)->err.getMessage().contains("1th"),10)
				//.onErrorComplete()
				/*.doOnError(err->{
					System.err.println("Do on error "+err.getMessage());
				})*/
				/*.onErrorResume(err->{
					if(err.getMessage().contains("1th"))
					{
						return Mono.just(100);
					}
					else
					{
						return Mono.error(err);
					}
				})*/
				.onErrorContinue((err,data)->{
					System.out.println("ErrorContinue "+data);
				})
				.doFinally(data->{
					System.out.println("Finally "+data);
				})
				.subscribe(len->{
					System.out.println("Length>> "+len);
				},(err)->{
					System.err.println(err);
				}
			);
	}
	
}

package com.turing.mongo.demo.reactive.operator;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class User
{
	String name ;
	public User(String name)
	{
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}
class NameNullException extends RuntimeException
{
	NameNullException(String message)
	{
		super(message);
	}
}
public class ErrorTest {
	
	/*
	boolean validName(String name)
	{
		if(name.length()>=3)
		{
			return true;
		}
		else
		{
			throw new RuntimeException("Invalid name");
		}
	}*/
	Mono<User> register(String name)
	{
		System.out.println("Register "+name);
		return Mono.just(new User(name));
	}
	Mono<String> validName(String name)
	{
		if(name==null)
		{
			return Mono.error(new NameNullException("Name is null"));
		}
		else if(name.length()>=3)
		{
			return Mono.just(name);
		}
		else
		{
			return Mono.error(new RuntimeException("Invalid name"));
		}
	}
	Mono<String> fallBack(Throwable e)
	{
		System.out.println("Fallback");
		return Mono.just("Dummy");
	}
	Mono<String> nullFallBack(Throwable e)
	{
		System.out.println("nullFallBack");
		return Mono.just("null value");
	}
	
	/*
	@Test
	public void errorTest()
	{
		
		this.validName("TK1")
			//.onErrorComplete()
			//.onErrorReturn("Dummy")
			//.onErrorResume(NameNullException.class,(e)->nullFallBack(e))
			//.onErrorResume(RuntimeException.class,(e)->fallBack(e))
			.onErrorMap(e->new RuntimeException("Invalid name error"))
			.flatMap(this::register)
			.doFinally(signal->{
				System.out.println("This run whatever");
			})
			.subscribe(user->{
				System.out.println("User registered "+user);
			});
	}
	*/
	@Test
	public void createErrorTest()
	{
		
		this.validName("TK1")
			.then(Mono.error(new RuntimeException("We create error")))
			.subscribe();
			//.onErrorComplete()
	}
	
}

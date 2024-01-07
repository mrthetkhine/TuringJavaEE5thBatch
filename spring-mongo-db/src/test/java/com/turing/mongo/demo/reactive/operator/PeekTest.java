package com.turing.mongo.demo.reactive.operator;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PeekTest {
	
	Mono<String> getTodos(Integer id)
	{
		WebClient client = WebClient.builder()
				  .baseUrl("https://jsonplaceholder.typicode.com")
				  .build();
		return client.get()
		  .uri("/todos/"+id)	
		  .retrieve()
		  .bodyToMono(String.class);
	}
	@Test
	public void testTransform()
	{
		Flux<Integer> todosIds = Flux.just(1,2,3,4,5);
		todosIds.flatMap(this::getTodos)
				.doOnNext(data->{
					System.out.println("doOnNext save"+data);
					//throw new RuntimeException("problem");
				})
				.doOnEach(signal->{
					System.out.println("onEach Signal "+signal);
				})
				.doOnSubscribe(subscriber->{
					System.out.println("Subscriber "+subscriber);
				})
				.doFirst(()->{
					System.out.println("dofirst ");
					//throw new RuntimeException("problem");
				})
				.doOnError((err)->{
					System.out.println("Do on error "+err.getMessage());
				})
				.doOnComplete(()->{
					System.out.println("Do on completed");
				})
				.doOnTerminate(()->{
					System.out.println("Do on doOnTerminate");
				})
				.log()
				.collectList()
				.subscribe(item->{
					System.out.println("Data "+item);
				});
				
		try
		{
			Thread.sleep(12000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

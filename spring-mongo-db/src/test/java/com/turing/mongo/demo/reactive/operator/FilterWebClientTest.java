package com.turing.mongo.demo.reactive.operator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FilterWebClientTest {
	
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
	public void testFilter()
	{
		Flux<Integer> todosIds = Flux.just(1,2,3,4,5);
			todosIds
				.filter(item->item%2!=0)
				.flatMap(this::getTodos)
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

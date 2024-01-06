package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientConcurrentTest {

	@Test
	public void testWebClient()
	{
		WebClient client = WebClient.builder()
					.baseUrl("https://hub.dummyapis.com")
				  .build();
		double start = System.currentTimeMillis();
		Mono<String> one = client.get()
			  .uri("/delay?seconds=5")	
			  .retrieve()
			  .bodyToMono(String.class)
			  .doOnError(e->{
				 System.err.println(e.getMessage()); 
			  });
		Mono<String> two =client.get()
				  .uri("/delay?seconds=5")	
				  .retrieve()
				  .bodyToMono(String.class);
		Mono<Tuple2<String,String>> result = Mono.zip(one, two);
		result.subscribe(data->{
			 double end = System.currentTimeMillis();
			  double time = end-start;
			  System.out.println("Time "+time);
			  System.out.println("Json "+data.getT1()); 
			  System.out.println("Json2 "+data.getT2()); 
				 		  
		});
		
		/*
		 StepVerifier.create(result)
	      .expectSubscription()
	      .consumeNextWith(e-> {})      
	      .thenAwait()
	      .verifyComplete();
	      */
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

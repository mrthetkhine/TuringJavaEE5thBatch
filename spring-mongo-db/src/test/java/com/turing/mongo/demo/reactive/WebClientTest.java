package com.turing.mongo.demo.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientTest {

	@Test
	public void testWebClient()
	{
		WebClient client = WebClient.builder()
				  .baseUrl("https://hub.dummyapis.com")
				  .build();
		double start = System.currentTimeMillis();
		Mono<String> result = client.get()
			  .uri("/delay?seconds=5")	
			  .retrieve()
			  .bodyToMono(String.class)
			  .doOnError(e->{
				 System.err.println(e.getMessage()); 
			  });
		result.subscribe(json->{
			
				 client.get()
				  .uri("/delay?seconds=5")	
				  .retrieve()
				  .bodyToMono(String.class)
				  .subscribe(json2->{
					  double end = System.currentTimeMillis();
					  double time = end-start;
					  System.out.println("Time "+time);
					  System.out.println("Json "+json); 
					  System.out.println("Json2 "+json2); 
				  });
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

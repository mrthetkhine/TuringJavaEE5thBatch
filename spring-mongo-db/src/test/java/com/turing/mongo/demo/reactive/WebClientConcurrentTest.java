package com.turing.mongo.demo.reactive;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientConcurrentTest {

	WebClient client;
	
	@BeforeEach
	void init()
	{
		HttpClient httpClient = HttpClient.create()
				.doOnConnected(conn -> conn
						.addHandlerLast(new ReadTimeoutHandler(10))
						.addHandlerLast(new WriteTimeoutHandler(10)))
				//.responseTimeout(Duration.ofSeconds(10))
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

		client =  WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.baseUrl("https://hub.dummyapis.com")
				.build();
	}
	@Test
	public void testWebClient()
	{
		
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

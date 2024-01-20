package com.turing.mongo.demo.reactive.webclient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.turing.mongo.demo.dto.TodoDto;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientExceptionTest {

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
				.baseUrl("http://localhost:8080/api/dummy")
				.build();
	}
	/*
	@Test
	public void testException()
	{
		client.get()
				  .uri("/500")	
				  .retrieve()
				  .onStatus(HttpStatusCode::is4xxClientError, response->{
					  System.out.println("400 Error "+response.statusCode());
					  return Mono.empty();
				  })
				  .onStatus(HttpStatusCode::is5xxServerError, response->{
					  System.out.println("500 Error "+response);
					  return Mono.error(new RuntimeException("500 server error"));
				  })
				  .bodyToMono(TodoDto.class)
				  .doOnError(e->{
						 System.err.println("Error message==>"+e.getMessage()); 
					  })
				  .subscribe(data->{
					  System.out.println("Data "+data);
				  });
				  
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
	@Test
	public void testExchange()
	{
		client.get()
		  .uri("/500")	
		  .exchangeToMono(response->{
			  System.out.println("Response "+response.statusCode());
			  if(response.statusCode().equals(HttpStatus.OK))
			  {
				  //return Mono.just(response);
				  return response.bodyToMono(TodoDto.class);
			  }
			  else if(response.statusCode().equals(HttpStatus.valueOf(404)))
			  {
				  return Mono.error(new RuntimeException("404 Not found"));
			  }
			  else
			  {	  
				  return Mono.error(new RuntimeException("Something went wrong"));
			  }
		  })
		  .doOnError(e->{
				 System.err.println("Error message==>"+e.getMessage()); 
			  })
		  .subscribe(data->{
			  System.out.println("Data "+data);
		  },err->{
			  System.out.println("On Error "+err);
		  });
		  
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

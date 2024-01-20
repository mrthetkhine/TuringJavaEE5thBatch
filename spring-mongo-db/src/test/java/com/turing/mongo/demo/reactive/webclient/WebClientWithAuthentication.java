package com.turing.mongo.demo.reactive.webclient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.turing.mongo.demo.dto.TodoDto;
import com.turing.mongo.demo.reactive.webclient.model.AuthRequest;
import com.turing.mongo.demo.reactive.webclient.model.AuthResponse;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebClientWithAuthentication {

	/*
	 * https://fakeapi.platzi.com/en/rest/auth-jwt/
	 * */
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
				.baseUrl("https://api.escuelajs.co")
				.build();
	}
	
	Mono<AuthResponse> login()
	{
		AuthRequest authRequest = new AuthRequest();
		authRequest.setEmail("john@mail.com");
		authRequest.setPassword("changeme");
		Mono<AuthRequest> request = Mono.just(authRequest);
		return client.post()
			.uri("/api/v1/auth/login")
			.contentType(MediaType.APPLICATION_JSON)
			.body(request,AuthRequest.class)
			//.retrieve()
			//.bodyToMono(AuthResponse.class)
			.exchangeToMono(response->{
				System.out.println("Response "+response.statusCode());
				if(response.statusCode().equals(HttpStatus.valueOf(201)))
				{
					return response.bodyToMono(AuthResponse.class);
				}
				else
				{
					return Mono.error(new RuntimeException("Invalid login"));
				}
			});
			
	}
	private Mono<? extends String> getProfile(AuthResponse authResponse) {
		String accessToken = authResponse.getAccess_token();
		return client.get()
			  .uri("api/v1/auth/profile")
			  .header("Authorization", "Bearer "+accessToken)
			  //.contentType(MediaType.APPLICATION_JSON)
			  .exchangeToMono(response->{
					System.out.println("Response "+response.statusCode());
					if(response.statusCode().equals(HttpStatus.valueOf(200)))
					{
						return response.bodyToMono(String.class);
					}
					else
					{
						return Mono.error(new RuntimeException("Cannot get profile data"));
					}
				});
	}
	@Test
	public void testExchange()
	{
		
		this.login()
			.flatMap(this::getProfile)
			.subscribe(data->{
				System.out.println("Profile data "+data);
			},error->{
				System.err.println(error);
			});
			
		  
		  
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}

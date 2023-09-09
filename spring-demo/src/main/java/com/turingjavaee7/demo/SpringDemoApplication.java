package com.turingjavaee7.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.service.impl.ExampleBean;
import com.turingjavaee7.demo.service.impl.HelloMessageGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringDemoApplication {

	@Bean
	public ExampleBean exampleBean()
	{
		log.info("Invoke via factory method");
		return new ExampleBean();
	}
	
	@Bean
	@RequestScope
	public HelloMessageGenerator requestScopedBean() {
		log.info("HelloMessageBean created ");
	    return new HelloMessageGenerator();
	}
	
	@Bean
	@SessionScope
	public ShoppingCart shoppingCart()
	{
		log.info("Shopping cart created ");
		return new ShoppingCart();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}

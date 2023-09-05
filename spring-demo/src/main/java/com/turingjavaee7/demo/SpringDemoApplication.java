package com.turingjavaee7.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.turingjavaee7.demo.service.impl.ExampleBean;

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
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}

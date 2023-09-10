package com.turingjavaee7.demo.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleBean {
	
	public ExampleBean()
	{
		log.info("Example Bean created");
	}
	@PostConstruct
	public void init()
	{
		log.info("@PostConstruct Example bean");
	}
	@PreDestroy
	public void destroy()
	{
		log.info("@PreDestroy Example bean");
	}
	public void api()
	{
		log.info("API method from example bean");
	}
}

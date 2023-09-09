package com.turingjavaee7.demo.service.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleBean {
	
	public ExampleBean()
	{
		log.info("Example Bean created");
	}
	public void api()
	{
		log.info("API method from example bean");
	}
}

package com.turingjavaee7.demo.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.PrototypeService;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class PrototypeBean implements PrototypeService{
	public PrototypeBean()
	{
		log.info("Prorotypebean created " +this);
	}
	public void api()
	{
		log.info("API called");
	}
}

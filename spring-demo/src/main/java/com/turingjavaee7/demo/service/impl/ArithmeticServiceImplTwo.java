package com.turingjavaee7.demo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.ArithmeticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("arithTwo")
public class ArithmeticServiceImplTwo implements ArithmeticService{

	public ArithmeticServiceImplTwo()
	{
		log.info("Arithmetic Service Impl 2 created");
	}
	@Override
	public int add(int a, int b) {
		log.info("Using Arithmetic version 2");
		return a+b;
	}

}

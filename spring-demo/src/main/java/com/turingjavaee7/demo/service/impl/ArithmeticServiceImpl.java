package com.turingjavaee7.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.ArithmeticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class ArithmeticServiceImpl implements ArithmeticService{

	ArithmeticServiceImpl()
	{
		log.info("Arithmetic Service Impl created");
	}
	@Override
	public int add(int a, int b) {
		
		return a+b;
	}

}

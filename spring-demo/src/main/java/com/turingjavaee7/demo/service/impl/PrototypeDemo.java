package com.turingjavaee7.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.turingjavaee7.demo.service.PrototypeService;

public class PrototypeDemo {
	@Autowired
	PrototypeService prototypeService;
	
	public PrototypeService getPrototype()
	{
		return this.prototypeService;
	}
}

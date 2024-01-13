package com.turing.mongo.demo.controller.rest.exception;

public class BusinessException extends RuntimeException{
	public BusinessException(String message)
	{
		super(message);
	}
}

package com.turing.jpa.demo;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[]args)
	{
		/*
		String str = null;
		String upper = str.toUpperCase();
		int length = upper.length();
		
		System.out.println("Length "+length);
		*/
		String str = "hello";
		Optional<String> opt = Optional.ofNullable(str);
		Integer result = opt.map(x->x.toUpperCase())
							.map(x->x.length())
							.orElse(0);
		System.out.println("Result "+result);
	}
}

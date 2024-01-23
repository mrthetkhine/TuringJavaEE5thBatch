package com.turing.mongo.demo.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashTest {
	@Test
	public void test()
	{
		BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
		System.out.println("Brcypt hash "+bcrypt.encode("admin"));
	}
}

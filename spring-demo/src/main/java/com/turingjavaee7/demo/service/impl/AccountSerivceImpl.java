package com.turingjavaee7.demo.service.impl;

import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.AccountService;
import com.turingjavaee7.demo.service.AuthenticationException;

@Service
public class AccountSerivceImpl implements AccountService {

	@Override
	public boolean login(String username, String password) throws AuthenticationException {
		if("admin".equals(username)&& "admin".equals(password))
		{
			return true;
		}
		else
		{
			throw new AuthenticationException("Invalid username or password");
		}
	}

}

package com.turingjavaee7.demo.service;

public interface AccountService {
	boolean login(String username, String password) throws AuthenticationException;
}

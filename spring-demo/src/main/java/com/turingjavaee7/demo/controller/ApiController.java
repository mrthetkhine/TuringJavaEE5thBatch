package com.turingjavaee7.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turingjavaee7.demo.model.ShoppingCart;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping
	ShoppingCart getShoppingCart()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("One");
		cart.addToCart("Item Two");
		return cart;
	}
}

package com.turingjavaee7.demo.model;

import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<String> items;
	
	public ShoppingCart()
	{
		this.items = new ArrayList<String>();
	}
	public void addToCart(String item)
	{
		this.items.add(item);
	}
	public ArrayList<String> getItems()
	{
		return this.items;
	}
	
}

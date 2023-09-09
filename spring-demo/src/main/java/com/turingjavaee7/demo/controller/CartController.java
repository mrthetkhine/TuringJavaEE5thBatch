package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.service.ArithmeticService;
import com.turingjavaee7.demo.service.PrototypeService;
import com.turingjavaee7.demo.service.impl.ExampleBean;
import com.turingjavaee7.demo.service.impl.HelloMessageGenerator;
import com.turingjavaee7.demo.service.impl.PrototypeBean;
import com.turingjavaee7.demo.service.impl.PrototypeDemo;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shop")
public class CartController {
	
	@Autowired
	ShoppingCart shoppingCart;
	
	@GetMapping("/addToCart")
    public String getRequestScopeMessage(@RequestParam String item) {
		this.shoppingCart.addToCart(item);
		for(String it : this.shoppingCart.getItems())
		{
			log.info("Item > "+ it);
		}
        return "shoppingCart";
    }

}

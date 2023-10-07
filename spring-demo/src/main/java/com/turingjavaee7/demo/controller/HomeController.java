package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.model.Store;
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
public class HomeController {
	@Value("${catalog.name}") String catalog;
	
	int a;
	
	@Autowired
	//@Qualifier("arithTwo")
	private ArithmeticService arithmeticService;
	/*
	public void setArithmeticService(ArithmeticService arithService)
	{
		log.info("Setter injected for Arithmetic Service");
		this.arithmeticService = arithService;
	}
	*/
	/*
	@Autowired
	ExampleBean exampleBean;
	*/
	@Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;
	
	public HomeController(ExampleBean exampleBean) {
		log.info("Home Controller created ");
	}
	
	@Autowired
	Store<Integer> integerStore;
	
	@GetMapping("/")
	String home()
	{
		
		try
		{
			log.info("Catalog "+catalog);
			log.info("Handleby thread "+ Thread.currentThread().getName());
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//log.info("Home controller / "+ this.a);
		
		//log.info("Get / "+ arithmeticService.add(1, 2));
		//log.info("Service "+ arithmeticService);
		a++;
	
		return "home";
	}
	@GetMapping("/throw")
	String throwException() throws Exception
	{
		
		throw new Exception("Just throw");
		//return "home";
	}
	@GetMapping("/search")
    public String search(@RequestParam Integer query) {
		log.info("Query "+query);
        return "scopesExample";
    }
	@GetMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
		log.info("HelloMessage Generator "+ this.requestScopedBean);
        model.addAttribute("previousMessage", requestScopedBean.getMessage());
        requestScopedBean.setMessage("Good morning!");
        model.addAttribute("currentMessage", requestScopedBean.getMessage());
        
        return "scopesExample";
    }
	@Resource(name = "appScopedBean")
    HelloMessageGenerator appScopedBean;

	@GetMapping("/scopes/application")
    public String getApplicationScopeMessage(final Model model) {
        model.addAttribute("previousMessage", appScopedBean.getMessage());
        appScopedBean.setMessage("Good afternoon!");
        model.addAttribute("currentMessage", appScopedBean.getMessage());
        return "appScopedBean";
    }
	
	@GetMapping("/cart/json")
	@ResponseBody ShoppingCart getShoppingCart()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("One");
		cart.addToCart("Item Two");
		return cart;
	}

	
}

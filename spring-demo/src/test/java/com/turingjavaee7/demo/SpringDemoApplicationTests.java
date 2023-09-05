package com.turingjavaee7.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.turingjavaee7.demo.controller.HomeController;

@WebMvcTest(HomeController.class)
//@SpringBootTest
class SpringDemoApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testHelloWorld() {
		
		try {
			mockMvc.perform(get("/"))
					.andExpect(status().isOk())
					.andExpect(view().name("home"))
					.andExpect(content().string(containsString("Welcome")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

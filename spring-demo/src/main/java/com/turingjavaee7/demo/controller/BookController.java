package com.turingjavaee7.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	String getAllBook()
	{
		List<Book> books = this.bookService.getAllBook();
		for(Book book : books)
		{
			log.info("Book "+book);
		}
		return "hello";
	}
	
	@GetMapping("/{id}")
	String getBookById(@PathVariable String id)
	{
		Book book = this.bookService.getBookById(id);
		return "hello";
	}
}

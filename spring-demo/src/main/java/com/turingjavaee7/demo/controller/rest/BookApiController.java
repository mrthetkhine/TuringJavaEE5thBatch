package com.turingjavaee7.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.turingjavaee7.demo.service.BookService;
import com.turingjavaee7.demo.service.exception.BusinesLogicException;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import com.turingjavaee7.demo.controller.rest.error.ApiErrorResponse;
import com.turingjavaee7.demo.model.*;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookApiController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	List<Book> getAllBook()
	{
		log.info("GET /api/books");
		return this.bookService.getAllBook();
	}
	@GetMapping("/{bookId}")
	ResponseEntity<Object> getBookById(@PathVariable Long bookId)
	{
		log.info("GET /api/books/"+bookId);
		Book book = null;
		try
		{
			book = this.bookService.getBookById(bookId);
			return ResponseEntity.ok(book);
		}
		catch(Exception e)
		{
			log.error("getBookById "+e.getMessage());
			ApiErrorResponse error = new ApiErrorResponse("1001", "No such book with bookId "+bookId);
			return ResponseEntity.badRequest()
								 .body(error);
		}
	}
	
	@PostMapping
	ResponseEntity<Object> saveBook(@RequestBody @Valid Book book,
									BindingResult result)
	{
		log.info("POST saveBook "+book);
		if(result.hasErrors())
		{
			log.info("Validation error in creating book "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			Book savedBook = bookService.saveBook(book);
			return ResponseEntity.status(HttpStatus.CREATED)
								.body(savedBook);
		}
	}
	@PutMapping("/{bookId}")
	ResponseEntity<Object> updateBook(@PathVariable String bookId,@RequestBody @Valid Book book,
									BindingResult result)
	{
		log.info("PUT updateBook id "+bookId+"  "+book);
		if(result.hasErrors())
		{
			log.info("Validation error in updating book "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			Book updatedBook = bookService.updateBook(book);
			return ResponseEntity.ok()
								.body(updatedBook);
		}
	}
	@DeleteMapping("/{bookId}")
	ResponseEntity<Object> deleteBook(@PathVariable Long bookId)
	{
		log.info("Delete book id "+bookId+"  ");
		Book deletedeBook;
		try {
			deletedeBook = bookService.deleteBookById(bookId);
			return ResponseEntity.ok()
					.body(deletedeBook);
		} catch (BusinesLogicException e) {
			return ResponseEntity.badRequest()
				 	.body(e);
		}
		
	}
}

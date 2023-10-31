package com.turingjavaee7.demo.dao;

import java.util.List;

import com.turingjavaee7.demo.model.*;
public interface BookDao {
	List<Book> getAllBooks();
	Book getBookById(Long id);
	Book saveBook(Book book);
	Book updateBook(Book book);
	Book deleteBook(Long id);
}

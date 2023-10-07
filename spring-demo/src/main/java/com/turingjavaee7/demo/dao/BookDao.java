package com.turingjavaee7.demo.dao;

import java.util.List;

import com.turingjavaee7.demo.model.*;
public interface BookDao {
	List<Book> getAllBooks();
	Book getBookById(String id);
	Book saveBook(Book book);
	Book updateBook(Book book);
	Book deleteBook(String id);
}

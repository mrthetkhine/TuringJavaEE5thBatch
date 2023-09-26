package com.turingjavaee7.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> getAllBook() {
		
		return this.bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(String id) {
		
		return this.bookDao.getBookById(id);
	}

	@Override
	public void saveBook(Book book) {
		this.bookDao.saveBook(book);
	}

}

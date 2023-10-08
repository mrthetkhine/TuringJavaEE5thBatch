package com.turingjavaee7.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.controller.rest.BookApiController;
import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.service.BookService;
import com.turingjavaee7.demo.service.exception.BusinesLogicException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> getAllBook() {
		
		log.info("getAllBook api service");
		return this.bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(String id) {
		
		return this.bookDao.getBookById(id);
	}

	@Override
	public Book saveBook(Book book) {
		return this.bookDao.saveBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		return this.bookDao.updateBook(book);
		
	}

	@Override
	public Book deleteBookById(String id)throws BusinesLogicException{
		
		try
		{
			return this.bookDao.deleteBook(id);
		}
		catch(Exception e)
		{
			throw new BusinesLogicException("Book not found");
		}
		
	}

}

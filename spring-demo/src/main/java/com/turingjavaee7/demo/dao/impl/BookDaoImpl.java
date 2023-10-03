package com.turingjavaee7.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;

@Repository
public class BookDaoImpl implements BookDao{
	
	List<Book> books;
	BookDaoImpl()
	{
		this.books = new ArrayList<Book>();
		
		this.books.add(new Book("1","Title 1","Author 1"));
		this.books.add(new Book("2","Title 2","Author 2"));
	}

	@Override
	public List<Book> getAllBooks() {
	
		return this.books;
	}

	@Override
	public Book getBookById(String id) {

		return this.books.stream()
					.filter(book->book.getId().equals(id))
					.collect(Collectors.toList())
					.get(0);
	}

	@Override
	public Book saveBook(Book book) {
		this.books.add(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		Book originalBook = this.getBookById(book.getId());
		originalBook.setAuthor(book.getAuthor());
		originalBook.setTitle(book.getTitle());
		
		return originalBook;
	}

	@Override
	public void deleteBook(String id) {
		List<Book> books = this.books.stream()
				.filter(book->!book.getId().equals(id))
				.collect(Collectors.toList());
		this.books = books;		
	}

}

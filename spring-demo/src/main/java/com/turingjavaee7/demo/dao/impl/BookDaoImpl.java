package com.turingjavaee7.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;

@Repository
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	List<Book> books;
	BookDaoImpl()
	{
		this.books = new ArrayList<Book>();
		
		this.books.add(new Book(1L,"Title 1","Author 1"));
		this.books.add(new Book(2L,"Title 2","Author 2"));
	}

	@Override
	public List<Book> getAllBooks() {
	
		 return jdbcTemplate.query(
			      "SELECT id, title, author FROM Book;",
			      this::mapRowToBook);
	}
	private Book mapRowToBook(ResultSet row, int rowNum)throws SQLException
	{
		return new Book(row.getLong("ID"),row.getString("title"),row.getString("author"));
	}
	@Override
	public Book getBookById(Long id) {

		List<Book> books = jdbcTemplate.query(
			      "SELECT id, title, author FROM Book WHERE ID=?",
			      this::mapRowToBook,
			      id);
		return books.get(0);
	}

	@Override
	public Book saveBook(Book book) {
		
		String INSERT_SQL =  "INSERT INTO Book ( author, title) values ( ?, ?)";
		/*
		jdbcTemplate.update(
			      "INSERT INTO Book ( author, title) values ( ?, ?)",
			      book.getAuthor(),
			      book.getTitle());
		*/
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(INSERT_SQL, new String[] {"id"});
		            ps.setString(1, book.getAuthor());
		            ps.setString(2, book.getTitle());
		            return ps;
		        }
		    },
		    keyHolder);
		book.setId(keyHolder.getKey().longValue());
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		/*
		Book originalBook = this.getBookById(book.getId());
		originalBook.setAuthor(book.getAuthor());
		originalBook.setTitle(book.getTitle());
		*/
		 this.jdbcTemplate.update(
	                "UPDATE Book SET author = ?, title=? WHERE ID = ?", 
	                book.getAuthor(),book.getTitle(), book.getId());
		return book;
	}

	@Override
	public Book deleteBook(Long id) {
		Book deletedBook = this.getBookById(id);
		 this.jdbcTemplate.update(
	                "DELETE FROM Book WHERE ID = ?", 
	                id);
		return deletedBook;
	}

}

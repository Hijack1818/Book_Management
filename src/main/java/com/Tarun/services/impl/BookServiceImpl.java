package com.Tarun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tarun.entities.Book;
import com.Tarun.entities.BookCategory;
import com.Tarun.entities.BookPublisher;
import com.Tarun.repositories.BookRepositories;
import com.Tarun.services.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepositories bookRepositories;

	@Override
	public List<Book> getAllBooks() {
		return bookRepositories.findAll();
	}

	public void saveBook(Book book) {
		bookRepositories.save(book);
	}

	public void removeBook(int bid) {
		bookRepositories.deleteById(bid);
	}

	public Book getBookById(int bid) {
		return bookRepositories.findById(bid).orElse(null);
	}

	public void updateBook(Book book) {
		Book b= bookRepositories.findById(book.getBookid()).orElse(null);
		b.setAuthor(book.getAuthor());
		b.setCatid(book.getCatid());
		b.setCopies(book.getCopies());
		b.setPrice(book.getPrice());
		b.setPubid(book.getPubid());
		b.setTitle(book.getTitle());
		
		bookRepositories.save(b);
	}

	public List<Book> getAllBooksById(int bid) {
		List<Book> book= bookRepositories.findAllByBookid(bid);
		return book;
	}

	public List<Book> getAllBooksByAuthor(String author) {
		return bookRepositories.findAllByAuthor(author);
	}

	public List<Book> getAllBooksByTitle(String title) {
		return bookRepositories.findAllByTitle(title);
	}

	public List<Book> getAllBooksByCatid(BookCategory cid) {
		
		return bookRepositories.findAllByCatid(cid);
	}

	public List<Book> getAllBooksByPubid(BookPublisher pub) {
		return bookRepositories.findAllByPubid(pub);
	}
}

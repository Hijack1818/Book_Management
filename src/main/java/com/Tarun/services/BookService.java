package com.Tarun.services;

import java.util.List;

import com.Tarun.entities.Book;
import com.Tarun.entities.BookCategory;
import com.Tarun.entities.BookPublisher;

public interface BookService {

	List<Book> getAllBooks();

	void saveBook(Book book);

	void removeBook(int bid);

	Book getBookById(int bid);

	void updateBook(Book book);

	List<Book> getAllBooksById(int bid);

	List<Book> getAllBooksByAuthor(String author);

	List<Book> getAllBooksByTitle(String title);

	List<Book> getAllBooksByCatid(BookCategory cid);

	List<Book> getAllBooksByPubid(BookPublisher pub);

}

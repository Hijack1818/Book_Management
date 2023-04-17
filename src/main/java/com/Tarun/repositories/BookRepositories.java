package com.Tarun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tarun.entities.Book;
import com.Tarun.entities.BookCategory;
import com.Tarun.entities.BookPublisher;

public interface BookRepositories extends JpaRepository<Book, Integer>{

	
	List<Book> findAllByBookid(int bid);

	List<Book> findAllByAuthor(String author);

	List<Book> findAllByTitle(String title);

	List<Book> findAllByCatid(BookCategory cid);

	List<Book> findAllByPubid(BookPublisher pub);

}

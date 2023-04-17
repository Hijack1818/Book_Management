package com.Tarun.services;

import java.util.List;

import com.Tarun.entities.BookPublisher;

public interface BookPublisherService {

	List<String> getAllBookPublishersName();

	List<BookPublisher> getAllBookPublisherList();

	BookPublisher getBookPublisherById(int pubid);

	void saveBookPublisher(BookPublisher cat);

	void removeCategory(int pubid);

	void updatePublisher(BookPublisher cat);

}

package com.Tarun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tarun.entities.BookPublisher;
import com.Tarun.repositories.BookPublisherRepository;
import com.Tarun.services.BookPublisherService;

@Service
public class BookPublisherServiceImpl implements BookPublisherService{
	
	@Autowired
	private BookPublisherRepository bookPublisherRepository;

	public List<String> getAllBookPublishersName() {
		return bookPublisherRepository.findAllPublisher();
	}

	public List<BookPublisher> getAllBookPublisherList() {
		return bookPublisherRepository.findAll();
	}

	public BookPublisher getBookPublisherById(int pubid) {
		return bookPublisherRepository.findById(pubid).orElse(null);
	}

	public void saveBookPublisher(BookPublisher cat) {
		bookPublisherRepository.save(cat);
	}

	public void removeCategory(int pubid) {
		bookPublisherRepository.deleteById(pubid);
	}

	public void updatePublisher(BookPublisher cat) {
		BookPublisher pub= bookPublisherRepository.findById(cat.getPubid()).orElse(null);
		pub.setEmail(cat.getEmail());
		pub.setPhone(cat.getPhone());
		pub.setPublisher(cat.getPublisher());
		bookPublisherRepository.save(pub);
	}
}

package com.Tarun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tarun.entities.BookCategory;
import com.Tarun.repositories.BookCategoryRepository;
import com.Tarun.services.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService{

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public List<String> getAllBookCategoryName() {
		return bookCategoryRepository.findAllCategory();
	}

	public List<BookCategory> getAllBookCategoryList() {
		return bookCategoryRepository.findAll();
	}

	public void saveBookCategory(BookCategory cat) {
		bookCategoryRepository.save(cat);
	}

	public BookCategory getBookCategoryByName(String category) {
		return bookCategoryRepository.findByCategory(category);
	}

	@Override
	public void updateCategory(BookCategory cat) {
		BookCategory cat1= bookCategoryRepository.findById(cat.getCatid()).orElse(null);
		
		if(cat1!=null) {
			cat1.setCategory(cat.getCategory());
			cat1.setDescription(cat.getDescription());
			bookCategoryRepository.save(cat1);
		}
	}

	public BookCategory getBookCategory(int cid) {
		return bookCategoryRepository.findById(cid).orElse(null);
	}

	public void removeCategory(int cid) {
		bookCategoryRepository.deleteById(cid);
	}
}

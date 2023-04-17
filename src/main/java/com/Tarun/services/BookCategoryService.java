package com.Tarun.services;

import java.util.List;

import com.Tarun.entities.BookCategory;

public interface BookCategoryService {

	List<String> getAllBookCategoryName();

	List<BookCategory> getAllBookCategoryList();

	void saveBookCategory(BookCategory cat);

	BookCategory getBookCategoryByName(String category);

	void updateCategory(BookCategory cat);

	BookCategory getBookCategory(int cid);

	void removeCategory(int cid);

}

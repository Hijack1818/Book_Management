package com.Tarun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Tarun.entities.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{
	@Query("select category from BookCategory")
	List<String> findAllCategory();

	BookCategory findByCategory(String category);

}

package com.Tarun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Tarun.entities.BookPublisher;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer>{
	@Query("select publisher from BookPublisher")
	List<String> findAllPublisher();

}

package com.Tarun.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Book {
	@Id
	@GeneratedValue(generator = "book_seq")
	@SequenceGenerator(name = "book_seq", initialValue = 11111, allocationSize = 1)
	private int bookid;
	private String title;
	private String author;
	@ManyToOne
	@JoinColumn(name="catid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BookCategory catid;
	@ManyToOne
	@JoinColumn(name="pubid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BookPublisher pubid;
	private int copies;
	private int price;
	

	public BookCategory getCatid() {
		return catid;
	}

	public void setCatid(BookCategory catid) {
		this.catid = catid;
	}

	public BookPublisher getPubid() {
		return pubid;
	}

	public void setPubid(BookPublisher pubid) {
		this.pubid = pubid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

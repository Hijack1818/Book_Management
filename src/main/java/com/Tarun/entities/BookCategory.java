package com.Tarun.entities;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "category"))
public class BookCategory 
{
	@Id
	@GeneratedValue(generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq",initialValue = 111,allocationSize = 1)
	private int catid;
	private String category;
	private String description;
//	@OneToMany
//	List<Book> bookList;
//	public List<Book> getBookList() {
//		return bookList;
//	}
//	public void setBookList(List<Book> bookList) {
//		this.bookList = bookList;
//	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

package com.Tarun.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "publisher"))
public class BookPublisher 
{
	@Id
	@GeneratedValue(generator = "pub_seq")
	@SequenceGenerator(name = "pub_seq",initialValue = 1111,allocationSize = 1)
	private int pubid;
	private String publisher;
	private String phone;
	private String email;
	
//	@OneToMany
//	List<Book> bookList;
//	public List<Book> getBookList() {
//		return bookList;
//	}
//	public void setBookList(List<Book> bookList) {
//		this.bookList = bookList;
//	}
	public int getPubid() {
		return pubid;
	}
	public void setPubid(int pubid) {
		this.pubid = pubid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

package com.nit.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {

	private int bookId;
	private String bookName;
	private String Author;
	private Float price; 
	private String publisher;
	private String status;
	private String category;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "BookBO [bookId=" + bookId + ", bookName=" + bookName + ", Author=" + Author + ", price=" + price
				+ ", publisher=" + publisher + ", status=" + status + ", category=" + category + "]";
	}
	
	
	
	
}

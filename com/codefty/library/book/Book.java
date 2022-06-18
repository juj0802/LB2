package com.codefty.library.book;

import com.codefty.library.common.RentalStatus;

public class Book {
	
	private long serialNum; // 도서 일련 번호
	private String bookTitle;  // 도서 제목 
	private String author; // 도서 저자
	private String publisher; // 출판사 
	private int rentalDays; // 도서 대여 가능일
	private RentalStatus status; // 도서 대여 상태 
	
	public Book(long serialNum, String bookTitle, String author, String publisher, int rentalDays,
			RentalStatus status) {
		this.serialNum = serialNum;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.rentalDays = rentalDays;
		this.status = status;
	}

	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	public RentalStatus getStatus() {
		return status;
	}

	public void setStatus(RentalStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [serialNum=" + serialNum + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher="
				+ publisher + ", rentalDays=" + rentalDays + ", status=" + status + "]";
	}
}
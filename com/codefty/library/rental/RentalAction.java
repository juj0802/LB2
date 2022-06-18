package com.codefty.library.rental;

import com.codefty.library.book.Book;

public abstract class RentalAction {
	
	// 도서 대여
	public abstract void rentBook(Book book);
	
	// 도서 반납 
	public abstract void returnBook(Book book);
	
	// 도서 검수
	public abstract void checkingBook(Book book);
	
	// 도서 대기
	public abstract void readyBook(Book book);
	
}

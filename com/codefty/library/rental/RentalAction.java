package com.codefty.library.rental;

import com.codefty.library.book.Book;

public abstract class RentalAction {
	
	// ���� �뿩
	public abstract void rentBook(Book book);
	
	// ���� �ݳ� 
	public abstract void returnBook(Book book);
	
	// ���� �˼�
	public abstract void checkingBook(Book book);
	
	// ���� ���
	public abstract void readyBook(Book book);
	
}

package com.codefty.library.book;

public abstract class BookAction {
	/**
	 * 도서 등록
	 * @param book
	 */
	public abstract void register(Book book);
	
	/**
	 * 도서 정보 수정
	 * @param book
	 */
	public abstract void update(Book book);
}

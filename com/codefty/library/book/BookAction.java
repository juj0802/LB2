package com.codefty.library.book;

public abstract class BookAction {
	/**
	 * ���� ���
	 * @param book
	 */
	public abstract void register(Book book);
	
	/**
	 * ���� ���� ����
	 * @param book
	 */
	public abstract void update(Book book);
}

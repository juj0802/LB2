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
	
	/**
	 * ���� ���� ����
	 * @param book
	 */
	public abstract void delete(Book book);
	
	/**
	 * ���� ���� ��ȸ 
	 * 
	 * @param serialNum : ���� �Ϸù�ȣ 
	 */
	public abstract Book get(long serialNum);
}

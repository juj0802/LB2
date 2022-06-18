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
	
	/**
	 * 도서 정보 삭제
	 * @param book
	 */
	public abstract void delete(Book book);
	
	/**
	 * 도서 정보 조회 
	 * 
	 * @param serialNum : 도서 일련번호 
	 */
	public abstract Book get(long serialNum);
}

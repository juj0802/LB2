package com.codefty.library.book;

import java.util.*;
import java.util.stream.*;

public class BookService extends BookAction {

	private BookDao bookDao;
	
	public BookService() {
		bookDao = BookDao.getInstance();
	}
	
	/**
	 * 도서 등록 
	 * 
	 * @param Book book
	 * @throws BookValidationException
	 */
	@Override
	public void register(Book book) {
		validateBook(book);
		bookDao.addBook(book);
	}

	@Override
	public void update(Book book) {
		isBookExists(book);
		bookDao.update(book);
	}

	@Override
	public void delete(Book book) {
		isBookExists(book);
		bookDao.delete(book);
		
	}

	@Override
	public Book get(long serialNum) {
		Book book = bookDao.get(serialNum);
		if (book == null) {
			throw new BookNotExistsException();
		}
		
		return book;
	}
	
	/**
	 * 책을 저장할때 필수 데이터가 다 있는 체크
	 * 
	 * @param book
	 * @throws BookValidationException
	 */
	private void validateBook(Book book) {
		ArrayList<String> missingFields = new ArrayList<>();
		if (book == null) {
			throw new BookValidationException("도서 정보가 입력되지 않습니다.");
		}
		
		if (book.getBookTitle().trim().isEmpty()) {
			missingFields.add("도서명");
		}
		
		if (book.getPublisher().trim().isEmpty()) {
			missingFields.add("출판사");
		}
		
		if (book.getAuthor().trim().isEmpty()) {
			missingFields.add("저자");
		}
		
		if (missingFields.size() > 0) { // 누락된 도서 정보가 있음 -> 예외 발생 
			String msg = "필수 입력 항목이 누락되었습니다. - ";
			msg += missingFields.stream().collect(Collectors.joining(","));
			
			throw new BookValidationException(msg);
		}	
	}
	
	/**
	 * 책이 있는지 여부 체크하는 메서드 
	 * 
	 * @param book
	 * @throws BookNotExistsException
	 */
	private void isBookExists(Book book) {
		if (book == null) {
			throw new BookNotExistsException();
		}
		
		Book _book = get(book.getSerialNum());
		if (_book == null) {
			throw new BookNotExistsException();
		}
	}
}
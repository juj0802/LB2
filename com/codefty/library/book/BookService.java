package com.codefty.library.book;

import java.util.*;
import java.util.stream.*;

public class BookService extends BookAction {

	private BookDao bookDao;
	
	public BookService() {
		bookDao = BookDao.getInstance();
	}
	
	/**
	 * ���� ��� 
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
	 * å�� �����Ҷ� �ʼ� �����Ͱ� �� �ִ� üũ
	 * 
	 * @param book
	 * @throws BookValidationException
	 */
	private void validateBook(Book book) {
		ArrayList<String> missingFields = new ArrayList<>();
		if (book == null) {
			throw new BookValidationException("���� ������ �Էµ��� �ʽ��ϴ�.");
		}
		
		if (book.getBookTitle().trim().isEmpty()) {
			missingFields.add("������");
		}
		
		if (book.getPublisher().trim().isEmpty()) {
			missingFields.add("���ǻ�");
		}
		
		if (book.getAuthor().trim().isEmpty()) {
			missingFields.add("����");
		}
		
		if (missingFields.size() > 0) { // ������ ���� ������ ���� -> ���� �߻� 
			String msg = "�ʼ� �Է� �׸��� �����Ǿ����ϴ�. - ";
			msg += missingFields.stream().collect(Collectors.joining(","));
			
			throw new BookValidationException(msg);
		}	
	}
	
	/**
	 * å�� �ִ��� ���� üũ�ϴ� �޼��� 
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
package com.codefty.library.book;

import com.codefty.library.common.CommonException;

/**
 * 도서 정보가 없을때 발생하는 예외
 * 
 * @author LEE YONGGYO
 */
public class BookNotExistsException extends CommonException {
	public BookNotExistsException() {
		this("도서 정보가 없습니다.");
	}
	
	public BookNotExistsException(String message) {
		super(null, message);
	}
}
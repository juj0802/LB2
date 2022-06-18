package com.codefty.library.book;

import com.codefty.library.common.CommonException;

/**
 * 도서를 등록할때 누락된 항목이 있는 경우
 * 
 * @author LEE YONGGYO
 */
public class BookValidationException extends CommonException {
	public BookValidationException(String message) {
		super(null, message);
	}
}

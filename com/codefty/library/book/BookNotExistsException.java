package com.codefty.library.book;

import com.codefty.library.common.CommonException;

/**
 * ���� ������ ������ �߻��ϴ� ����
 * 
 * @author LEE YONGGYO
 */
public class BookNotExistsException extends CommonException {
	public BookNotExistsException() {
		this("���� ������ �����ϴ�.");
	}
	
	public BookNotExistsException(String message) {
		super(null, message);
	}
}
package com.codefty.library.book;

import java.util.*;
import java.io.*;

public class BookDao {
	
	private static BookDao instance = new BookDao();
	
	private List<Book> books = new ArrayList<>();
	
	private String dataPath;
	
	private long serialNum; // 도서 일련번호
	
	private BookDao() {
		String path = new File("").getAbsolutePath() + File.separator + "data";
		File dir = new File(path);
		if (!dir.exists()) { 
			dir.mkdir();
		}
		dataPath = path + File.separator + "books.obj";
		
		serialNum = 100000L;
	}
	
	
	/**
	 * 파일로 저장된 도서 데이터를 가져오는 기능 
	 * 
	 * @return
	 */
	public List<Book> loadBooks() {
		
		if (!(new File(dataPath).exists())) { // 저장된 파일이 없는 경우 
			return books;
		}
		
		try (FileInputStream fis = new FileInputStream(dataPath);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
				books = (List<Book>)ois.readObject();
				
				// 다음 도서 일련번호 갱신 
				if (books.size() > 0) {
					serialNum = books.get(books.size() - 1).getSerialNum() + 1;
				}
				
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	/**
	 * 도서 정보를 파일로 저장 
	 * 
	 */
	public void saveBooks() {
		try (FileOutputStream fos = new FileOutputStream(dataPath);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 도서 추가 
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		book.setSerialNum(serialNum);
		books.add(book);
		saveBooks();
	}
	
	/**
	 * 도서 수정 
	 * 
	 * @param book
	 */
	public void update(Book book) {
		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			if (b.getSerialNum() == book.getSerialNum()) {
				books.set(i, book);
				break;
			}
		}
		
		saveBooks();
	}
	
	/**
	 * 도서 삭제
	 * 
	 * @param book
	 */
	public void delete(Book book) {
		books.remove(book);
		saveBooks();
	}
	
	/**
	 * 도서 정보 조회
	 * 
	 * @param serialNum : 도서 일련번호 
	 * @return Book
	 */
	public Book get(long serialNum) {
		for (Book book : books) {
			if (book.getSerialNum() == serialNum) {
				return book;
			}
		}
		
		return null;
	}
	
	public static BookDao getInstance() {
		if (instance == null) {
			instance = new BookDao();
		}
		
		return instance;
	}
}





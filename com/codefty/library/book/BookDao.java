package com.codefty.library.book;

import java.util.*;
import java.io.*;

public class BookDao {
	
	private static BookDao instance = new BookDao();
	
	private List<Book> books = new ArrayList<>();
	
	private String dataPath;
	
	private long serialNum; // ���� �Ϸù�ȣ
	
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
	 * ���Ϸ� ����� ���� �����͸� �������� ��� 
	 * 
	 * @return
	 */
	public List<Book> loadBooks() {
		
		if (!(new File(dataPath).exists())) { // ����� ������ ���� ��� 
			return books;
		}
		
		try (FileInputStream fis = new FileInputStream(dataPath);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
				books = (List<Book>)ois.readObject();
				
				// ���� ���� �Ϸù�ȣ ���� 
				if (books.size() > 0) {
					serialNum = books.get(books.size() - 1).getSerialNum() + 1;
				}
				
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	/**
	 * ���� ������ ���Ϸ� ���� 
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
	 * ���� �߰� 
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		book.setSerialNum(serialNum);
		books.add(book);
		saveBooks();
	}
	
	/**
	 * ���� ���� 
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
	 * ���� ����
	 * 
	 * @param book
	 */
	public void delete(Book book) {
		books.remove(book);
		saveBooks();
	}
	
	/**
	 * ���� ���� ��ȸ
	 * 
	 * @param serialNum : ���� �Ϸù�ȣ 
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





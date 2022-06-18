# 도서관리 프로그램
GUI로 구성된 도서 관리 프로그램

## 필요 기능 정리
### 도서 등록, 수정, 정보 조회, 삭제 
- 도서 등록 정보
	* 도서 일련번호
	* 도서 제목
	* 도서 저자
	* 도서 출판사
	* 도서 대여 가능일
	* 도서 대여 상태 
	
### 도서 검색 
- 도서 검색 항목 : 통합검색, 일련번호, 제목, 저자, 출판사, 대여 상태 

### 도서 대여, 반납
- 도서 대여 상태 : 준비 -> 대여 -> 반납 -> 검수 -> 준비
	* 준비 -> 대여 
	* 대여 -> 반납
	* 반납 -> 검수 
	* 검수 -> 준비
	

## 설계
### com.codefty.library.book : 도서 등록, 수정, 삭제, 조회
```java
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
```
- Book : DTO(Data Transfer Object)
- BookDao : (Data Access Object) - 직접 파일에 접근해서 조회, 저장
- BookService : 등록, 수정, 삭제 등의 기능을 수행

### com.codefty.libary.common : 공통 기능, 상수 
- 도서 대여상태 
```java
public enum RentalStatus {
	READY,
	RENTAL,
	RETURN ,
	CHECKING,
}
```

### com.codefty.library.rental : 도서 대여, 반납
```java
// 도서 대여
	public abstract void rentBook(Book book);
	
	// 도서 반납 
	public abstract void returnBook(Book book);
	
	// 도서 검수
	public abstract void checkingBook(Book book);
	
	// 도서 대기
	public abstract void readyBook(Book book);
```







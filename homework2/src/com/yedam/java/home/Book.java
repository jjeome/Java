package com.yedam.java.home;

//vo클래스(datatransfer):정보를 저장하는 클래스 - 필드 ,게터, 세터만 가짐
public class Book {

	//필드
	//인스턴스에 독립적으로 정보를 가지는 애들
	private long ISBN;
	private String bookName;
	private int bookPrice;
	
	//생성자
	public Book() {}
	
	public Book(String bookName, int bookPrice, long ISBN) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.ISBN = ISBN;
	}
	
	
	//메서드
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getBookPrice() {
		return bookPrice;
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	public long getISBN() {
		return ISBN;
	}
	
	
	public void showInfo() {
		System.out.println("도서 이름 : "+bookName+", 가격 :" + bookPrice+ "ISBN : " +ISBN);
	}
	
}

package com.yedam.java.proffesor;

// VO, DTO 클래스 : 정보를 저장하는 클래스
public class Book {
	//필드
	private static int serialNum = 1000; //공유가능한 기준점이 되는 번호
	
	private int isbn;
	private String title;
	private int price;
	
	//생성자
	public Book(String title, int price) {
		serialNum++;
		this.isbn = serialNum;
		this.title = title;
		this.price = price;
	}

	//메소드
	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Book.serialNum = serialNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void showInfo() {
		String info = "ISBN : "+this.isbn+", 제목 : " + this.title+", 가격 : "+this.price;
		System.out.println(info);
	}
	
	
}

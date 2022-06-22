package com.yedam.pro.book;

public class Books {
	private String bookName;
	private String bookWriter;
	private String bookContent;
	private int bookRental; //대여 여부 - 0:대여가능 1:대여불가
	private String bookRentInfo;
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookWriter() {
		return bookWriter;
	}
	
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	
	public String getBookContent() {
		return bookContent;
	}
	
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	
	public int getBookRental() {
		return bookRental;
	}
	
	public void setBookRental(int bookRental) {
		this.bookRental = bookRental;
	}
	
	public void setBookRentInfo(String bookRentInfo) {
		this.bookRentInfo = bookRentInfo;
	}
	
	public String getBookRentInfo() {
		if(bookRental == 0) {
			return "대여가능";
		} else {
			return "대여중";
		}
	}
	
	
	@Override
	public String toString() {
		return "책제목 : "+bookName+", 저자명 : "+bookWriter+", 내용 : "+bookContent+", 대여여부 : "+getBookRentInfo();
	}

}

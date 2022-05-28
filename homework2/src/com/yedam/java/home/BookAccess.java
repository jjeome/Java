package com.yedam.java.home;

public interface BookAccess { //저장소 등록, 조회, 삭제
	//등록
	public void insert(Book book);
	//전체 조회
	public Book[] selectAll();
	//단건 조회
	public Book selectOne(int isbn);
	//삭제
	public void delete(String bookName);
	
}

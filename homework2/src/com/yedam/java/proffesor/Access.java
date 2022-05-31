package com.yedam.java.proffesor;
//db와 연결해서 사용할 인터페이스
public interface Access { //SRUD : DB에 접속했을 때 가장 기본적으로 일어나는 기능들
	// 등록
	void insert(Book book);
	// 수정
	void update(Book book);
	// 삭제
	void delete(int isbn);
	// 전체조회
	Book[] selectAll();
	// 단건조회
	Book selectOne(int isbn);

}

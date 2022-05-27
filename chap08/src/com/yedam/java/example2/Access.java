package com.yedam.java.example2;

public interface Access {//DB접근하기
	//저장소에 대해 사용방법을 정의
	//저장소기능 : 등록, 수정, 전체 조회, 삭제, 단건 조회
	
	//등록
	public void inser(Student student);
	//수정
	public void update(Student student);
	//삭제
	public void delete(int studentId);
	//전체조회
	public Student[] selectAll();
	//단건조회
	public Student selectOne(int studentId);
	
	
	
}

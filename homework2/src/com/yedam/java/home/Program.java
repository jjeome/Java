package com.yedam.java.home;

public interface Program {
// 입력된 전체정보 출력 특징 조건의 정보를 출력 분석
	
	
	//메뉴출력
	public void menuPrint();
	//정보입력
	public void inputInfo(BookAccess bookaccess);
	//입력된 전체정보 출력
	public void printAllInfo(BookAccess bookaccess);
	//특정 조건의 정보 출력
	public void printSelectInfo(BookAccess bookaccess);
	//분석
	public void PrintRepo(BookAccess bookaccess);
}

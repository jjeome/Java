package com.yedam.java.example2;

public interface Program {
	/*
	 * 정보입력 입력된 전체정보 출력 특정 조건의 정보를 출력 분석
	 */

	// 메뉴출력
	public void menuPrint();

	// 정보 입력
	public void inputInfo(Access access);

	// 입력된 전체정보 출력
	public void printAllInfo(Access access);

	// 특정 조건의 정보를 출력
	public void printInfo(Access access);

	// 분석
	public void printRepot(Access access);
}

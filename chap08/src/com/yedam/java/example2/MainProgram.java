package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {
	//필드 
	private Scanner sc = new Scanner(System.in);
	private Access dao = StudentRepo.getInstace(); //저장소
	private Program pro = new StudentProgram(); // 프로그램
	//생성자
	public MainProgram() {
		while(true) {
			//메뉴 출력
			pro.menuPrint();
			//메뉴 선택
			int menuNo = menuSelect();
			//각 메뉴 실행
			if(menuNo==1) {
				pro.inputInfo(dao);
			} else if(menuNo==2) {
				pro.printAllInfo(dao);
			} else if (menuNo==3) {
				pro.printInfo(dao);
			} else if (menuNo==4) {
				pro.printRepot(dao);
			} else if(menuNo==5) {
				exit();
				break;
			} else {
				
			}
		}
	}
	//메소드
	private int menuSelect() {
		System.out.println("선택> ");
		return sc.nextInt();
	}
		
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
		
		
	
}

package com.yedam.java.home;

import java.util.Scanner;

public class MainProgram{
	//필드
	private Scanner sc = new Scanner(System.in);
	private BookAccess dao = BookRepo.getInstance();
	private Program pro = new BookProgram();
	
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
			} else if(menuNo==3) {
				pro.printSelectInfo(dao);
			} else if(menuNo==4) {
				pro.PrintRepo(dao); 
			} else if(menuNo==5) {
				exit();
				break;
			} 
		}
	}

	private int menuSelect() {
		System.out.println("선택> ");
		return sc.nextInt();
	}

	private void exit() {
		System.out.println("프로그램을 종료");
	}
}


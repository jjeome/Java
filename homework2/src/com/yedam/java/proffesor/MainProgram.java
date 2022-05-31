package com.yedam.java.proffesor;

import java.util.Scanner;

public class MainProgram {
	private Program pro = new BookProgram();
	public MainProgram() {
		while(true) {
			pro.menuPrint();
			
			int menuNo = inputMenu();
			
			if(menuNo==1) {
				pro.inputInfo();
			} else if(menuNo==2) {
				pro.printAllInfo();
			} else if(menuNo==3) {
				pro.printInfo();
			} else if(menuNo==4) {
				pro.printRepot();
			} else if(menuNo==5) {
				exit();
				break;
			}
		}
		
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private int inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴> ");
		return sc.nextInt();
	}
}

package com.yedam.app;

import java.util.Scanner;

public class StockManagement {
	Scanner sc = new Scanner(System.in);
	public StockManagement() {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo == 1) {
				//제품등록
				insertProduct();
			} else if(menuNo == 2) {
				//제품 입고
				stockedProduct();
			} else if(menuNo == 3) {
				//제품 출고
				takeOutProduct();
			} else if(menuNo == 4) {
				//제품 재고
				countOfProduct();
			} else if(menuNo == 5) {
				//제품 조회
				selectAllProduct();
			} else if(menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}
	

	private void inputError() {
		System.out.println("메뉴에 맞춰 입력하세요");
	}


	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}


	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
		return 0;
	}


	private void menuPrint() {
		System.out.println("==========================================================");
		System.out.println(" 1.제품등록 | 2.제품입고 | 3.제품출고 | 4.제품재고 | 5.전체재고 | 9.종료 ");
		System.out.println("==========================================================");
	}
}

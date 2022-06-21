package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.products.ProductInfoManagement;
import com.yedam.app.products.ProductsDAO;

public class Management {
	//필드
	protected Scanner sc = new Scanner(System.in);
	//공유되는 테이블3개
	protected ProductsDAO pDAO = ProductsDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeoutGoodsDAO tDAO = TakeoutGoodsDAO.getInstance();
	
	//실행시키고자 하는 코드들 감싸는 역할 -> 생성자 아님
	//하나의 프로젝트 안에서 모두 다 쓸 틀
	public void run() { 
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo==1) {
				//제품 정보 관리
				new ProductInfoManagement();
			} else if (menuNo ==2) {
				//제품 관리
				new ProductStockManagement();
			} else if( menuNo == 9) {
				//프로그램 종료
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}

	//메소드
	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주시기 바랍니다.");
		}
		return menuNo;
	}

	protected void menuPrint() {
		System.out.println("=================================");
		System.out.println(" 1.제품정보관리 | 2.제품재고관리 | 9.종료");
		System.out.println("=================================");
	}
	
	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	protected void showInputError() {
		System.out.println("메뉴에서 입력해주시기 바랍니다.");
	}
	
	
}

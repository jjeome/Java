package com.yedam.homework;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		ProductSystem prosys = new ProductSystem();
		
		while(run) {
			System.out.println("메뉴를 선택하세요");
			System.out.println(" 1.상품 수 | 2.상품 및 가격 입력 | 3.제품별 가격 | 4.분석 | 5.종료 ");
			System.out.println("입력> ");
			int selectNo = scan.nextInt();
			
			if(selectNo ==1) {
				System.out.println("상품 수 입력> ");
				int size = scan.nextInt();
				prosys.setListSize(size);
				System.out.println();
				
			} else if(selectNo==2) {
				System.out.println("상품 및 가격 입력> ");
				String name = scan.next();
				int price = scan.nextInt();
				prosys.putProduct(name, price);
				System.out.println();
				
			} else if(selectNo==3) {
				System.out.println("제품별 가격> ");
				prosys.printList();
				System.out.println();
				
			} else if(selectNo==4) {
				System.out.println("분석> 최고가격> "+prosys.printMax());
				System.out.println("분석> 총합(금액)> "+prosys.printSum());
			} else {
				System.out.println("시스템을 종료합니다.");
				run = false;
			}
		}
	}

}

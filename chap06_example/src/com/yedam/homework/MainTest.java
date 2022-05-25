package com.yedam.homework;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		ProductSystem prosys = new ProductSystem();
		//nextLine()은 입력값과 엔터까지 읽음, 단어가 아니라 문장으로 인정함 -enter를 포함한 데이터를 그대로 읽음
		//그냥 next()는 엔터키 빼고 값만 받음(엔터 무시하고 글자만 가져감)

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
				System.out.println("상품 입력> ");
				String name = scan.next();//입력 값이 하나일때
				System.out.println("상품 가격 입력> ");
				int price = scan.nextInt();
				prosys.putProduct(name, price);
				System.out.println();
				
			} else if(selectNo==3) {
				System.out.println("제품별 가격> ");
				prosys.printList();
				System.out.println();
				
			} else if(selectNo==4) {
				Product temp = prosys.printMax();
				System.out.println("분석> 최고가격 제품> "+temp.getName());
				System.out.println("분석> 총합(금액)> "+prosys.printSum());
				
			} else {
				System.out.println("시스템을 종료합니다.");
				run = false;
			}
		}
	}

}

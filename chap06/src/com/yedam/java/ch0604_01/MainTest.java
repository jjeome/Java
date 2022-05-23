package com.yedam.java.ch0604_01;

import java.util.Scanner;

import com.yedam.java.ch0604.Program;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator calculator = new Calculator();//while문 돌릴동안 값을 저장하는 클래스
		boolean run = true;
		
		while(run) {
			System.out.println(" 메뉴를 선택하세요 ");
			System.out.println(" 1.개수 입력 | 2. 숫자 입력 | 3. 더하기 | 4. 빼기 | 5. 나누기 | 6. 곱하기 ");
			System.out.println("선택> ");
			int selectNo = scan.nextInt();
			
			if(selectNo==1) {
				System.out.println("갯수> ");
				int size = scan.nextInt();
				calculator.setArrSize(size);
			} else if(selectNo==2) {
				System.out.println("입력> ");
				int num = scan.nextInt();
				calculator.setNum(num);
			} else if(selectNo==3) {
				calculator.plus();
			} else if(selectNo==4) {
				calculator.minus();
			} else if(selectNo==5) {
				calculator.division();
			} else if(selectNo==6) {
				calculator.multi();
			} else if(selectNo==7) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}

}

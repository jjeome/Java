package com.yedam.java.ch0604;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		Program program = new Program(); //new연산자 계속 만들필요 없기때문에 밖에다 선언.
		
		while(run) {
			System.out.println(" 1.학생 수 | 2. 점수 입력 | 3. 점수리스트 | 4. 분석 | 5. 종료 ");
			System.out.println("선택> ");
			int selectNo = Integer.parseInt(scan.nextLine());
			
			if(selectNo ==1) {
				System.out.println("학생 수>");
				int student = Integer.parseInt(scan.nextLine());
				program.setStudentNum(student);
			} else if(selectNo ==2) {
				System.out.println("점수> ");
				int scores = Integer.parseInt(scan.nextLine());
				program.setStudentScore(scores);
			} else if(selectNo == 3) {
				program.printScores();
			} else if(selectNo == 4) {
				program.printResult();
			} else if(selectNo == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}

}

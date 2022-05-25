package com.yedam.java.test;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		StudentSystem student = new StudentSystem();

		while (run) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("===1.학생수 입력  2.학생정보 등록  3.학생정보 전체조회  4.학생정보 분석  5.종료===");
			System.out.println("선택> ");
			int selectNum = scan.nextInt();
		
		if(selectNum == 1) {
			System.out.println("학생 수 > ");
			int size = scan.nextInt();
			student.setStuNum(size);
			System.out.println();
			
		} else if(selectNum==2) {
			
			System.out.println("학번");
			int studentId = scan.nextInt();
			System.out.println("이름");
			String name = scan.next();
			System.out.println("점수");
			int scores = scan.nextInt();
			student.putStudent(studentId, name, scores);
			System.out.println();
			
		} else if(selectNum==3) {
			student.printList();
			System.out.println();
			
		} else if(selectNum==4) {
			Student temp = student.printMax();
			Student temp2 = student.printMin();
			
			System.out.println("최고 점수 : "+temp.getScores()+", 학번 : "+temp.getStudentId());
			System.out.println("최저 점수 : "+temp2.getScores()+", 학번 : "+temp2.getStudentId());
			System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점입니다.\n", student.printAvg());
		
		} else {
			System.out.println("프로그램 종료");
			run = false;
		}
		
		
		
		
		}

	}

}

package chap06;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		Homework Homework = new Homework();
		
		while(run) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.학생수 입력 2.학생점수 등록 3.학생점수 전체조회 4.학생정보 분석 5.종료" );
			System.out.println("입력> ");
			int selectNo = scan.nextInt();
			
			
			if(selectNo == 1) {
				System.out.println("1.학생 수 입력> ");
				int student = scan.nextInt();
				Homework.studentNum(student);
				System.out.println();
			} else if(selectNo ==2) {
				System.out.println("2.학생 점수 등록> ");
				int scores = scan.nextInt();
				Homework.scoresNum(scores);
				System.out.println();
			} else if(selectNo ==3) {
				System.out.println("학생 점수 전체 조회> ");
				Homework.printScores();
				System.out.println();
			} else if(selectNo ==4) {
				System.out.println("학생 정보 분석> ");
				Homework.printResult();
				System.out.println();
			} else if(selectNo == 5) {
				run = false;
				System.out.println("프로그램을 종료합니다.");
			}
		} 
	}

}

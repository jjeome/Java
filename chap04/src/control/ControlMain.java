package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score; // 점수 입력
		String grade; //등급
		
		
		//조건이 맞을 동안은 반복실행
		do {
			//점수 입력 받기
			score = Integer.parseInt(scan.nextLine());
			
			if (score == 0) {
				break; //반복문 빠져나감
			}

			//등급 계산
			if (score>=90) {
				grade = "A등급";
			} else if (score >= 80) {
				grade = "B등급";
			} else if (score >= 70){
				grade = "C등급";
			} else {
				grade = "D등급";
			}
			//등급 결과 출력
			System.out.printf("성적 %d는 %s 입니다.\n",score,grade);
			
		} while (true);
		System.out.println("프로그램 종료");
			
	}

}

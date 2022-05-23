package com.yedam.java.ch0604;
/* 1. 학생수 입력
 * 2. 점수입력
 * 3. 점수리스트 출력
 * 4. 분석 - 최고점수, 평균점수 출력
 * 5. 종료
 */

public class Program {
	// 필드
	int[] scores;
	int index;

	// 생성자
	Program() {
		index = -1; // 현재값이 들어가있는 위치 가리킴
	}

	// 메소드
	// 1.학생수 입력
	void setStudentNum(int student) {
		scores = new int[student];
	}

	// 2. 점수입력
	void setStudentScore(int score) {
		scores[++index] = score; // 현재 값이 저장되어있는 최대의 값
	}

	// 3. 점수리스트 출력(값반환X)
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scres[" + i + "]>" + scores[i]);
		}
	}
	/*
	 * 최댓값 구하기 
	 * int getMaxScore() { 
	 * int max = scores[0]; //기준점 잡아주기
	 *  for (int i=0; i<scores.length; i++) { 
	 *  	if(max < scores[i]) { 
	 *  		max = scores[i]; 
	 *  	} 
	 *  } return max; //max값 반환 
	 * }
	 *
	 * 평균구하기 
	 * double getAvgScore() { 
	 * 	int sum = 0; 
	 * 	for(int i=0; i<scores.length;i++) { 
	 * 	sum += scores[i]; 
	 * 	} return (double)sum/scores.length; 
	 * }
	 */

	// 내가 한거
	// 최댓값
	int setMaxScore() {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			}
		}
		return max;
	}

	// 평균
	double setAvg() {
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		avg = (double)sum / scores.length;
		return avg;
	}

	void printResult() {
		System.out.println("최고 점수: " + setMaxScore()); // 출력호출은 메소드 바로 호출해주면 됨.
		System.out.println("평균 점수: " + setAvg());
	}
}
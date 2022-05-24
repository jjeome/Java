package com.yedam.java.homework;

/*
 * 1.등록 기능 구현
 * 2.전체 조회 구현
 * 3.분석 기능 구현
 * 4.최고-최소점 구한 후 평균 구하기
 */
public class Homework {
	// 필드
	int[] scores;
	int index;

	// 생성자
	Homework() {
		index = -1; // 현재값이 들어가있는 위치 가리킴
	}

	// 1.학생수 입력
	void studentNum(int student) {
		scores = new int[student];
	}

	// 2.학생 점수 등록
	void scoresNum(int score) {
		scores[++index] = score;
	}

	// 3.학생점수 전체조회
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "]>" + scores[i]);
		}
	}

	// 4.학생 정보 분석 - 최고점
	int setMaxScore() {
		int max = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (max > scores[i]) {
				max = scores[i];
			}
		}
		return max;
	}

	// 4.학생 정보 분석 - 최소점
	int setMinScore() {
		int min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (min < scores[i]) {
				min = scores[i];
			}
		}
		return min;
	}

	void printResult() {
		System.out.println("최고 점수: " + setMaxScore()); // 출력호출은 메소드 바로 호출해주면 됨.
		System.out.println("최저 점수: " + setMinScore());
		System.out.printf("평균 점수: %.2f", setAvgScore());
	}

	// 4.학생 정보 분석 - 평균
	double setAvgScore() {
	int sum =0;
	double avg;
		for(int i=0; i<scores.length;i++) {
			sum += scores[i];
		}
		avg = (double)(sum-(setMinScore()+setMaxScore())) / (scores.length-2);
		return avg;
	}

}
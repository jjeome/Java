package com.yedam.java.test;

/*
 * 1. 학생 수 입력
 * 2. 학생 정보 등록
 * 2. 전체 조회
 * 3. 분석 기능 - 최고점
 * 4. 분석 기능 - 최저점
 * 5. 분석 기능 - 평균(학생정보 1번 제외하고 소수점 두자리로)
 */
public class StudentSystem {
	private Student[] list;
	private int index;

	public StudentSystem() {
		index = -1;
	}

	// 학생 수 입력
	public void setStuNum(int size) {
		list = new Student[size];
	}

	// 학생 정보 등록
	public void putStudent(int studentId, String name, int scores) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setName(name);
		student.setScores(scores);

		list[++index] = student;
	}

	// 학생정보 전체조회
	public void printList() {
		for (int i = 0; i <= index; i++) {
			Student student = list[i];
			System.out.println(student.getStudentId()+" 학번의 점수는 "+student.getScores()+"입니다.");
			//list[i].showInfo();
		}
	}

	// 최고점 및 최저점
	Student printMax() {
		Student test1 = new Student();
		int maxID = list[0].getStudentId();

		int max = list[0].getScores();
		for (int i = 0; i <= index; i++) {
			if (max < list[i].getScores()) {
				max = list[i].getScores();// 학점
				maxID = list[i].getStudentId();// 학번
			}
		}
		test1.setStudentId(maxID);
		test1.setScores(max);
		return test1;
	}

	
	Student printMin() {
		Student test2 = new Student();
		int minID = 0;
		int min = list[0].getScores();
		for (int i = 0; i <= index; i++) {
			if (min > list[i].getScores()) {
				min = list[i].getScores();// 학점
				minID = list[i].getStudentId();// 학번
			}
		}
		test2.setStudentId(minID);
		test2.setScores(min);
		return test2;
	
	}
	
	double printAvg() {
		int sum = 0;
		double result = 0;
		for (int i = 0; i <= index; i++) {
			sum += list[i].getScores();
		}
		result = (sum-(printMin().getScores()+printMax().getScores())/(list.length-2));
		return result;
	}

}

package com.yedam.java.test;

public class Student {
	//필드
	private int studentId;
	private int scores;
	private String name;
	
	//생성자
	public Student() {}
	
	public Student(int studentId, int scores, String name) {
		this.studentId = studentId;
		this.name = name;
	}
	
	//메소드
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public void setScores(int scores) {
		this.scores = scores;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public int getScores() {
		return scores;
	}
	
	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println(studentId + " 학번의 점수는 "+ scores +" 입니다.");
	}
	
}

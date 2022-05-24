package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		Student choi = new Student("최현정");
		System.out.println(Student.getSerialNum());
		System.out.println(choi.getName()+"님의 학번: "+choi.getStudentId());
		
		Student yoon = new Student("윤상혁");
		System.out.println(Student.getSerialNum());
		System.out.println(yoon.getName()+"님의 학번: "+yoon.getStudentId());
	
		System.out.println(choi.getName()+"님의 학번: "+choi.getStudentId());
	}

}

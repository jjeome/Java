package com.yedam.java.ch0605;

public class Planet {
	//필드
	final int radius; //생성자를 실행할 때 값을 초기화
	static final double pi = 3.1459; //값이 고정
	
	//생성자
	Planet(int radius) {
		this.radius = radius;
	}
	
	//메소드
	void getAres() {
		double result = 4 * Planet.pi * this.radius * this.radius;
		System.out.println("행성의 표면적 : " + result);
	}
}

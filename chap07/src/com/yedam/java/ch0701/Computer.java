package com.yedam.java.ch0701;

public class Computer extends Calculator {
	
	@Override//확실하게 확인을 해줌 부모랑 자식클래스. 메소드 재정의 할때마다 붙여주는게 좋음
	//@ : 어떤 것인지 간단하게 붙여주는.
	double areaCircle(double r) { //메소드 재정의는 실행블록 안에만 수정 가능.
		//System.out.println("부모 : "+super.areaCircle(r));
		System.out.println("Computer 객체");
		return Math.PI*r*r;
	}
	
	/*
	//메소드 재정의 하면 부모랑 자식 둘다 생기고, 자식메소드가 우선수위 높음
	void print() {
		super.areaCircle(5);
		areaCircle(5);
	}
	*/
}

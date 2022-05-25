package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {
	public SmartPhone(String model, String color) {
		super(model, color);
	}
	/*
	@Override
	void print() {
		System.out.println("휴대폰이 종료됩니다.");
		super.powerOff();
		super.print();
	}//오버라이딩은 할 수 없지만 호출은 가능.
	*/
	
	@Override
	protected void bell() { //protected 접근권한은 없지만 다른패키지에서 자식클래스는 접근 허용
		super.bell();
		System.out.println("벨 소리: 싸이 - that that!");
	}

	@Override
	void call() {
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");

	void print() {
		super.bell();
	}
	
}

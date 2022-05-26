package com.yedam.java.ch0703;

public class Dmb extends Phone {

	public Dmb(String model, String color) {
		super(model, color);
		
	}
	
	@Override
	public void powerOn() {
		super.powerOn();
		System.out.println("부팅이 완료되었습니다.");
	}
	
	public void showDmb() {
		System.out.println("DMB를 실행합니다.");
	}

	@Override //추상메소드 재정의->무조건 phone은 벨소리가 있어야한다는 강제성이 있음
	public void bell() {
		System.out.println("벨이 울립니다.");
		System.out.println("@#!@#!@#!@#");
	}
	
	
}

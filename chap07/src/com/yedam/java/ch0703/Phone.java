package com.yedam.java.ch0703;

public abstract class Phone {//추상클래스는 단독으로는 인스턴스 생성 불가
	//필드
	public String model;
	public String color;
	
	//생성자
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	//메소드
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	public abstract void bell();//접근제한자와 리턴타입 사이에 abstract쓰기.
	//실체클래스가 내용 정의해줘야함
}

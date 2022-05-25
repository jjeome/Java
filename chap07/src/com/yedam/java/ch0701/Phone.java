package com.yedam.java.ch0701;

public class Phone {
	//필드(기본정보)
	String model;
	String color;
	
	//생성자
	public Phone(String model, String color) {
		this.model = model;
		this. color = color;
	}
	
	
	
	//메소드(기능)
	final void powerON() { 
		System.out.println("전원을 켭니다.");
	}
	
	final void powerOff() { //아예 오버라이딩 할 때 보이지 않게 final 붙임
		System.out.println("전원을 끕니다.");
	}
	
	protected void bell() {
		System.out.println("벨이 울리고 진동을 일으킵니다.");
	}
	
	void call() {
		System.out.println("통화를 합니다.");
	}
	
	private void print() {
		System.out.println("테스트");
	}
}

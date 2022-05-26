package com.yedam.java.ch0703;

public class Dog extends Animal{
	//Animal 은 추상클래스이면서 동시에 메소드를 가지고 있으니까 정의를 해줘야함.
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}

package com.yedam.java.ch0703;

public abstract class Animal {
	
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();//소리를 여기서 구현할 수 없다면 시그니처만 만든것
	// 소리 구현은 추상메소드로 재정의.
}

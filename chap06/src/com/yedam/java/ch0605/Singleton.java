package com.yedam.java.ch0605;

public class Singleton {
	//필드
	private static Singleton singleton = new Singleton();
	
	//생성자
	private Singleton(){ //디폴트 생성자에 private만 붙이면 됨
		
	}
	
	//메소드 -싱글톤을 사용하려면 메소드를 이용해 사용해야 함
	static Singleton getinstance() {
		return singleton;
	}
}

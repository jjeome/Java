package com.yedam.java.ch0901;

public class Outer {
	//out의 필드와 메소드
	String field = "바깥클래스 - 필드";
	void method() {
		System.out.println("바깥클래스 - 메소드");
	}
	
	//Outer클래스에만 존재하는 메소드
	void methodA() {
		System.out.println("바깥클래스 - 메소드 A");
	}
	
	
	//인스턴스 멤버 클래스
	class Nested {
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		
		void print() {
			methodA();
			System.out.println(field);//nested 필드 -> 인스턴스 자신을 가리키기에 this사용 가능
			method();//nested 메소드
			System.out.println(Outer.this.field);//어느클래스의 this인지 명시(동명의 클래스와 메소드일때 구분지어주기)
			Outer.this.method();
		}
	}
	
	
	//중첩인터페이스 : 
	//인스턴스 인터페이스
	interface I { 
		int FIELD = 100;
		
		void method();
	}
	
	//정적 인터페이스 - UI프로그램에서 젤 많이 쓰임
	static interface N {
		int FIELD = 100;
		void method();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

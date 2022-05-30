package com.yedam.java.ch0901;

public class Z {
	//인스턴스 필드 ->Z클래스의 인스턴스가 존재한다는 뜻
	B field = new B(); //Z클래스의 인스턴스가 존재(무조건)
	C filed  = new C();//Z클래스의 정보만 있으면 됨 -> 인스턴스와는 무관하게 돌아가지만 Z클래스가 선언만 되어있으면 사용 가능
	
	//인스턴스 메소드
	void method1() {
		B var1 = new B();
		C Var2 = new C();
	}
	
	//정적 필드 초기화 - 정적 멤버 클래스만 사용가능함(인스턴스가 없이 움직여서)
	//Z클래스의 인스턴스가 없을 수 있다.
	// B field3 = new B(); //B클래스는 Z클래스의 인스턴스가 반드시 필요
	static C field4 = new C(); //Z클래스의 정보만 필요
	
	
	//정적 메소드
	static void method2() {
		//B var1 = new B();
		C var2 = new C();
	}
	
	
	//인스턴스 멤버 클래스 -> 얘를 감싸고 있는 바깥 클래스가 무조건 있어야함
	class B{}
	
	//정적 멤버 클래스 - 인스턴스와 무관하게 사용
	//정적 필드나 정적 메소드 사용가능
	//정적 필드 : 모든 인스턴스가 공유하고 하나의값을 가지기 위해
	static class C{}
	
}

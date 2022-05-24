package com.yedam.java.ch0606;
//default 접근 제한
//같은 패키지 안에서 다른 클래스 사용 가능


class A {
	
}

class B {
	A a;
	
	B(A a){
		this.a = a;
	}
	
	void method() {
		A a;
	}
}
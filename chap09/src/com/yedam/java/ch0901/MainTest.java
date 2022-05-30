package com.yedam.java.ch0901;

import com.yedam.java.ch0901.A.C;

public class MainTest {

	public static void main(String[] args) {
		
		A a = new A();
		
		System.out.println();
		
		//인스턴스 멤버 클래스
		//b클래스는 a클래스에 대한 인스턴스를 만들어줘야함
		 //클래스이름의 a가아니라 변수이름인 a로 접근함
		A.B b = a.new B(); 
		b.feild1 = 1; //클래스이름의 A가아니라 변수이름인 a로 접근함
		b.method1();
		
		//정적 멤버 클래스
		//C클래스에 대한 인스턴스 없지만 c클래스가 가지고 있는 정적필드에 접든하는데 문제없음
		A.C.field2 = 2;
		A.C.method2();
		
		System.out.println();
		A.C c = new A.C();//A클래스 내부에 있는 C클래스의 생성자를 직접적으로 호출.
		c.field1 = 1;
		c.method();
		
		System.out.println();
		//로컬클래스 - 그냥 메소드 호출
		a.method();
	}

}

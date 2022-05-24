package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C {
	//필드
	A a1 = new A(true);
	//A a2 = new A(1); 
	//A a3 = new A("문자열"); 
	
	//생성자
	public C() {
		A a = new A();
		a.field1 = 1;
		//a.field2 = 1;
		//a.field3 = 1;
		
		a.method1();
		//a.method2();
		//.method3();
	}
}

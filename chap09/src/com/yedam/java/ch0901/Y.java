package com.yedam.java.ch0901;

public class Y {
	//필드
	int field1;//인스턴스 필드
	static int field2;//정적 필드

	//메소드
	void method1() {}//인스턴스 메소드 
	static void method2() {}//정적 메소드
	

	//인스턴스 멤버 클래스
	 // 1.Y클래스의 인스턴스 필요 
	 //2.본인이 가지고 있는 필드 종류와 상관없이 다 접근 가능
	//즉 Y클래스의 인스턴스가 존재하기에 사용 가능.\
	//인스턴스가 접근할 수 있는 모든 내부멤버를 호출 할 수 있음.
	class B{
		void method() {
			field1 = 1;
			field2 = 1;
			
			method1();
			method2();
		}
	}
	
	//정적 멤버 클래스
	 //자기를 감싸는 클래스가 Y인지 모름
	 //Y클래스의 인스턴스가 없는데 사용해야 하니까 오류남
	 //정적 멤버 클래스를 사용할 때는 인스턴스 없이도 사용 가능
	static class C{ //->Y클래스의 인스턴스가 존재하지 않음
					//Y클래스의 정적 내부 멤버들만 호출할 수 있음
		void method() {
			//인스턴스 필드와 메소드 오류남
			//field1 = 1;
			field2 = 1;
			
			//method1();
			method2();
		}
	}
	
	int method(int arg) {
		int var = 1;
		//arg = 100;
		//var = 90;
		
		//로컬클래스 - 메소드가 호출될 때만 생성되고, 종료되면 사라짐
		//but 종료와 무관하게 사라지지 않을때도 있음(스레드일 경우)
		//로컬클래스를 사용하려면 바깥클래스의 메소드의 매개, 로컬 변수의 초기값을 지정해준 후 로컬클래스의 메소드안에서 매개, 로컬 변수 사용 가능
		class D {
			void method() {
				
				int reslut = arg + var;//처음에 시작될때 arg와 var를 복사를 해버림
			}
		}
		
		D d = new D();
		d.method();
		
		return var;
	}
	
}






















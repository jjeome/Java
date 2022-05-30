package com.yedam.java.ch0901;

public class A {
	
	A(){
		System.out.println("A instance");
	}
	
	//인스턴스 멤버 클래스 - 나를 감싸고 있는 클래스의 인스턴스를 만들어줘야함
	class B{ //정적 필드와 정적 메소드 선언 못함.(static허용X)
		//필드
		int feild1;
		//생성자
		B(){
			System.out.println("B instance");
		}
		//메소드
		void method1() {
			
		}

	}
	
	//정적 멤버 클래스 - 클래스 앞에 static 붙이는 것, 인스턴스와 무관하게 돌아감
	static class C{
		//필드
		int field1; //인스턴스필드
		static int field2;//정적 필드
		
		//생성자
		C(){
			System.out.println("C instance");
		}
		//메소드
		void method() {}
		static void method2() {}//정적 메소드
	}
	
	
	void method() {
		//로컬클래스 - A클래스의 메소드안에 생성
		//인스턴스 필드와 인스턴스 메소드만.
		//메소드를 벗어나면 사용못함.
		//메소드 안에서 사용하는 코드가 있어야함(선언 후 바로 사용)
		class D{
			//필드
			int field1;
			//생성자
			D(){
				System.out.println("D instance");
			}
			//메소드
			void method1() {}
			
		}
		
		//A클래스에 대한 접근이 필요없음 이미 A클래스 안의 메소드에 있기 때문에
		D d = new D();
		d.field1 = 1;
		d.method1();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

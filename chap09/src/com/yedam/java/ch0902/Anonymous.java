package com.yedam.java.ch0902;
//fiedl와 var는 서로 다른 객체임
//각각 존재하는 인스턴스인 것 단지 부모클래스만 같을 뿐
public class Anonymous {
	//필드
	Person field = new Person() {//익명 자식 객체
		//자식 객체의 필드와 메소드로 인해 다른 결과를 만들 수 있기에 익명 자식 객체 사용함
		//필드
		String job = "회사원";
		//메소드
		void work() {
			System.out.println("출근합니다.");
		}
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	}; 
	
	
	//생성자
	
	//메소드
	void method1() {
		//로컬변수에 익명 자식객체를 만들었음
		Person var = new Person() {
			//필드
			String job = "취준생";
			//메소드
			void walk() {
				System.out.println("면접 봅니다.");
			}
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
	
		var.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}

package com.yedam.java.ch0902;

public class PersonTest {

	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		
		//필드 - 익명 객체인 경우
		anonymous.field.wake();
		System.out.println();
		
		//로컬변수 - 익명 객체인 경우
		anonymous.method1();
		System.out.println();
		
		//매개변수 - 익명 객체인 경우
		anonymous.method2(new Person() {
			//필드와 메소드는 외부에서 호출이 불가
			//Person클래스에 정의되어 있는것만 호출가능
			//override로만 출력시킬수 있음
			//필드 
			String job = "학생";
			//메소드
			void study() {
				System.out.println("공부합니다.");
				System.out.println();
			}
			
			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});
	}

}

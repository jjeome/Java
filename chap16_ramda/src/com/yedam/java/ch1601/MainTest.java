package com.yedam.java.ch1601;

public class MainTest {

	public static void main(String[] args) {
		//method 메소드 하나를 가지고 있는 fi가 가지는 것은 인터페이스가 맞음
		//메소드에 대한 정의만 있으면 됨 -> 하나의 인스턴스를 만듬
		
		/* 
		 * 익명구현객체를 사용해 정석 대로 만들면,
		 * MyFunctionalInterface fi = new My FunctionalInterface() {
		 * @Override
		 * public void method(){
		 * 		System.out.println("익명구현객체실행")
		 * 	}
		 * };
		 */
		
		
		MyFunctionalInterface fi 
			= () -> { System.out.println("람다식 실행"); };
		fi.method();
		//메소드 시그니처에따라 매개변수 부분 비어두고, 실행할때 리턴타입이 없음
		
	}

}

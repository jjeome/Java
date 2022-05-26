package com.yedam.java.ch0702;

public class ChildTest2 {
	public static void main(String[] args) {
		GranPa pa = new Father();//Father의 인스턴스 참조
		pa.method();//내부적으로 값 손상x
		//pa = new Uncle();//granpa는 Uncle 인스턴스를 참조
		
		System.out.println();
		if(pa instanceof Father) {
		Father fa = (Father) pa;//강제 타입 변환
		fa.method();
		fa.method2();
		//타입이 다르면 자식 인스턴스만 호출
		} else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
	}	
}

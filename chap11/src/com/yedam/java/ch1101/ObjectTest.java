package com.yedam.java.ch1101;

import java.util.Date;

public class ObjectTest {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}
		
		if(obj1 == obj2) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}
		
		//내부 필드값 동일한 객체는?
		//셋 다 다르지만 논리적으로 m1과 m2는 필드값이 같아 동등함(메소드 재정의 하면 동등하게 나옴)
		//각각 개별로 인지함
		//메소드 재정의를 하고 안하고의 차이가 있음
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		Member m3 = new Member("red");
	
		if(m1.equals(m2)) {
			System.out.println("m1과 m2는 동등합니다.");
		} else {
			System.out.println("m1과 m2는 동등하지 않습니다.");
		}
		
		if(m1.equals(m3)) {
			System.out.println("m1과 m3는 동등합니다.");
		} else {
			System.out.println("m1과 m3는 동등하지 않습니다.");
		}
				
		Date date = new Date(); 
		System.out.println(date);
		
	}

	
}

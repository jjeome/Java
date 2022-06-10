package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String data1 = "Java";
		String data2 = new String("Java");
		
		//등호연산자는 다른 객체로 인식
		if(data1 == data2) {
			System.out.println("서로 같은 객체");
		} else {
			System.out.println("서로 다른 객체");
		}
		
		//set 컬렉션은 같은 객체로 인식
		//내부에 있는 필드값을 중심으로.
		Set<String> set = new HashSet<>();
		set.add(data1);
		set.add(data2);
		
		System.out.println("총 객체 수 : "+set.size());
	}

}

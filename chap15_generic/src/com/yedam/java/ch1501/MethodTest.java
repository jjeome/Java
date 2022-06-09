package com.yedam.java.ch1501;

public class MethodTest {

	public static void main(String[] args) {
		BoxA<Integer> intBox = Util.<Integer>boxing(100);
		
		
		//매개변수의 값이 하나라도 달라지면 밑의 boolean의 결과도 달라짐
		Pair<Integer, String> p1 = new Pair<>(1,"사과");
		Pair<Integer, String> p2 = new Pair<>(1,"귤");
		
		//경우에 따라 메소드 앞에 타입을 적어줘야 함
		//compare에 들어오는 매개변수로 유추 가능한 지에 따라 다름
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않습니다.");
		}
		
		//매개변수로 유추할 수 없는 경우에는 직접 사용할 타입을 넣어줌 
		Util.<String, Integer>printInfo("홍길동");
	}

}

package com.yedam.java.ch0605;

public class MathTest {

	public static void main(String[] args) {
		double result1 = 10 * 10 * Math.pi; //정적 필드값 사용
		int result2 = Math.plus(10, 5); //정적 메소드 사용
		int result3 = Math.minus(10, 5);
		
		System.out.println("result1: "+result1);
		System.out.println("result2: "+result2);
		System.out.println("result3: "+result3);
	}

}

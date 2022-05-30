package com.yedam.java.ch0901;

public class ZClassTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		
		Outer.Nested nested = outer.new Nested();
		nested.print();
	}

}

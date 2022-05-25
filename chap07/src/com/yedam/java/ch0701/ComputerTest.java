package com.yedam.java.ch0701;

public class ComputerTest {

	public static void main(String[] args) {
		//실행하는 주체에 따라 결과가 다르게 나온것:다형성
		//밑의 calculator와 computer의 결과가 다르게 나온것처럼
		Calculator cal = new Calculator();
		System.out.println("원 면적: "+cal.areaCircle(10));
		
		Computer com = new Computer();
		System.out.println("원 면적: "+com.areaCircle(10));
		
		System.out.println("");
		
		//com.print();
	}
	

}

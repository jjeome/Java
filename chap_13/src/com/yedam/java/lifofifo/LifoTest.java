package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {

	public static void main(String[] args) {
		
		Stack<Integer> box = new Stack<>();
		box.push(100);
		box.push(50);
		box.push(500);
		box.push(10);
		box.push(400);
		
		//출력결과는 입력 값 순서와 반대로 출력됨
		//pop : get메소드 + remove메소드 
		//꺼내지면서 최종적으로 모든 값들이 삭제되어야 while문이 종료됨
		while(!box.isEmpty()) {
			int value = box.pop();
			System.out.println("\tbox 값 : "+box.size());
			System.out.println("꺼내온 값 : "+value);
		}
		
	}

}

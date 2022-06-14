package com.yedam.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(100);
		que.offer(50);
		que.offer(500);
		que.offer(10);
		que.offer(400);
		
		//순차적으로 값이 꺼내짐
		while(!que.isEmpty()) {
			int value = que.poll();
			System.out.println("\tQueue 수 : "+que.size());
			System.out.println("꺼내온 값 : "+value);
		}
	}

}

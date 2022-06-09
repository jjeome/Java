package com.yedam.java.ch1202;

import java.util.Scanner;

public class PrintThreadTest {

	public static void main(String[] args) {
		//new PrintThread().start();
		Thread jobThread = new PrintThread();
		jobThread.start();
		
		System.out.println("프로그램을 종료합시겠습니까?");
		int result = new Scanner(System.in).nextInt();
		
		if(result>0) {
			jobThread.interrupt();
		}
	}

}

package com.yedam.java.ch1202;

public class PrintThread extends Thread{
	@Override
	public void run() {
	//작업 스레드가 실행할 내용 
		//interrupt 작업 중 일시적인 추가작업이 필요한 경우
		/*
		try {
			while(true) {
				System.out.println("실행중");
				Thread.sleep(1000);
			} 
		} catch (InterruptedException e) {
			System.out.println("interrut method 실행");
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}
	
	
	try {
		while(true) {
			System.out.println("실행중");
			Thread.sleep(1000);
		} 
	} catch (InterruptedException e) {
		System.out.println("interrut method 실행");
	}
	System.out.println("자원 정리");
	System.out.println("종료");
	
	
*/
}

		 

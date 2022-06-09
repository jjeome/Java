package com.yedam.java.ch1201;

public class ThreadA implements Runnable {

	//스레드에서 작동시키고자 하는 코드들
	@Override 	
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("현재 순서 : "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

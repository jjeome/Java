package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();//하나의 스레드
		System.out.println("메인 스레드 : "+main.getName());
		//스레드 : 스레드에 대한 제어와 정보가 들어있는 클래스
		//runnable을 만들어서 할건지 아니면 아래 처럼 할건지.
		//Runnable a = new ThreadA();
		//Thread thread = new Thread(a); //실제로 동작은 Thread가 함
		ThreadB thread = new ThreadB();
		thread.setName("threadA"); //원하는 이름 바꿀 수 있음
		System.out.println("작업 스레드 : "+thread.getName());
		thread.start();
		
		for(int i=1; i<=5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500); //0.5초 -sleep은 ms단위
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

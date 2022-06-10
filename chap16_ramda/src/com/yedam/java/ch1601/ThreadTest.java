package com.yedam.java.ch1601;

//스레드 구현인 Runnable을 이용한 람다식
public class ThreadTest {

	public static void main(String[] args) {
		//rn메소드에 대한 정의하면 됨
		Runnable rn = () -> {
			System.out.println("람다식으로 구현");
			for(int i=0; i<10; i++) {
				System.out.println(i);
			}
		};
		Thread thread = new Thread(rn);
		thread.start();
		
		
		//하나의 인스턴스를 만드는 거기 때문에 실행문에서 바로 적어줘도 가능
		thread = new Thread(()->{
			System.out.println("매개변수 -> 람다식");
			for(int i=10; i<=100; i+=10) {
				System.out.println(i);
			}
		});
		thread.start();
	}

}

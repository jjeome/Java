package com.yedam.java.ch0701;

public class MainTest {

	public static void main(String[] args) {
		DmbPhone dmb = new DmbPhone("슬라이드폰", "파랑");
		
		System.out.println("모델 : " + dmb.model);
		System.out.println("색상 : " + dmb.color);
		System.out.println("채널 : " + dmb.ch);
		
		dmb.powerON();
		dmb.bell();
		dmb.call();
		
		dmb.turnOnDmb();
	}

}

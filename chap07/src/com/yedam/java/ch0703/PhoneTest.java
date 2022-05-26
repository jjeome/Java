package com.yedam.java.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
		/* 기본클래스 사용 형식
		Phone phone = new Phone("Z플립", "블랙");
		phone.powerOn();
		*/
		
		Dmb dmb = new Dmb("Z플립" ,"블랙");
		dmb.powerOn();
		dmb.showDmb();
		dmb.bell();
	}

}

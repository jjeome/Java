package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		//myCar.speed = -50;
		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		
		
		myCar.setSpeed(50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도: " + myCar.getSpeed());
	}

}

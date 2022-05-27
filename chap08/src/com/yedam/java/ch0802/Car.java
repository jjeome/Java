package com.yedam.java.ch0802;

public class Car {
	Tire frontLeftTire = new KumhoTire();
	Tire frontRightTire = new KumhoTire();
	Tire backLefTire = new KumhoTire();
	Tire backRiTire = new KumhoTire();
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLefTire.roll();
		backRiTire.roll();
	}
}

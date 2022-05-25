package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {

	public SmartPhone(String model, String color) {
		super(model, color);
	}

	void print() {
		super.bell();
	}
	
	

}

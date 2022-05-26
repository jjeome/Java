package com.yedam.java.ch0702;

public class DriverTest {

	public static void main(String[] args) {
		Drive driver = new Drive();
		
		/*
		 * Bus bus = new Bus();
		 * driver.drive(bus);
		 * bus.run();
		 */
		
		
		driver.drive(new Bus());
		driver.drive(new Taxi());
		driver.drive(new Vehicle());
	}

}

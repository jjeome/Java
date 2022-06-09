package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calcultor cal = new Calcultor();
		cal.setMemory(100);
		
		User user1 = new User();
		user1.setCalculator(cal);
		user1.start();
		
		//Calcultor calTemp = new Calcultor();
		User user2 = new User();
		user2.setCalculator(cal);
		user2.start();
	}

}

package com.yedam.java.ch0602;

public class Main2 {

	public static void main(String[] args) {
		Car myCar = new Car("blue"); // 기본생성자는 필요하다면 명시적으로 생성해줘야함 자바가 만드는 기본생성자가 있기때문에.
		
		Car yourCar = new Car("티볼리","silver");
		
		Car newCar = new Car("레이", "yello", 120);
		
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println(" ");
		
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println(" ");
		
		System.out.println(newCar.model);
		System.out.println(newCar.color);
		System.out.println(newCar.maxSpeed);
	}

}

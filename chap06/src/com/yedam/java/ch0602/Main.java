package com.yedam.java.ch0602;

public class Main {

	public static void main(String[] args) {
		//clas내부의 필드 값 그대로 가져옴
		Car myCar = new Car();
		
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		
		myCar.speed = 100;//인스턴스에 값을 변경하면 그 변경한 값만 바뀌고 인스턴스끼리 영향x
		System.out.println(myCar.speed);
		
		System.out.println("");
		
		//위와 다른 인스턴스지만 class자체가 이미 값을 가지고 있어서 동일한 값이 나옴
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println(yourCar.speed);
		
		System.out.println(" ");
		
		Car blueCar = new Car("Blue");
		System.out.println(blueCar.color);
		
		Car newCar = new Car();
		System.out.println(newCar.color);
		
	}

}

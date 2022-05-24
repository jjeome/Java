package com.yedam.java.ch0605;

public class CarTest {

	public static void main(String[] args) {//main메소드 자체가 정적 메소드
		Car myCar = new Car("포르쉐"); // 메서드 호출
		Car yourCar = new Car("벤츠"); //생성자에서 매개변수로 값을 받는다해서 인수값 적어주기
		
		CarTest ct =new CarTest();		
		ct.print();
		//new연산자를 쓰고 나서 호출하기.
		
		myCar.run(); 
		System.out.println(yourCar.speed);
		yourCar.run();
	}
	
	public void print() {
		System.out.println("이것은 메소드입니다.");
	}

}

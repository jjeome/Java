package com.yedam.java.ch0601;

public class Main {

	//실행클래스
	public static void main(String[] args) {
		/*
		타입으로 클래스명 쓰고 변수명 = new 클래스명();
		동일한 이름의 클래스지만 주소값은 다름
		new 연산자는 무조건 새로운 인스턴스 생성됨
		동일한 연산자 쓰려면 복사해야함
		*/
		Car myCar = new Car();
		System.out.println(myCar);
		
		Car yourCar = new Car();
		System.out.println(yourCar);
	}

}

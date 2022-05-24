package com.yedam.java.ch0605;

public class Car {
	// 필드
	public String model;
	public int speed;

	// 정적 필드-생산 수량
	// static이 중복된다면 그냥 Car.count로 적기
	public static int count;

	// 생성자
	// 생성자는 class와 이름동일-경우에따라 매개변수도 가짐
	public Car(String model) {
		this.model = model; // 인스턴스 만들기위한 생성자
		// 인스턴스에서 정적 필드 사용하기 때문에 class이름을 빌려 정적 필드 가져옴
		Car.count++; // 인스턴스 만들어진 후 count++이 된 
	}

	// 메소드
	public void setSpeed(int speed) { // 외부에서 값을 받으면 필드에 저장
		this.speed = speed;
	}

	public void run() {
		for (int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속: " + this.speed + "km/h)");
		}
	}

}

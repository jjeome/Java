package com.yedam.java.ch0602;

public class Car {
	
	//필드(class의 기본 정보 또는 상태) 선언
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;

	//기본 생성자 호출 => 인스턴스 새로 생성한다라는 뜻.기존의 클래스 건드리는것이 아님
	Car() {}
	
	Car(String color){
		//this.color = color;//this=클래스 내부에서만 사용할 수 있음. 인스턴스의 필드 가리킴
		this("그랜저", color, 350);
		company = "기아";
	}
	
	//생성자오버로딩:매개변수의 타입과 순서 다르게 하기. 이름과 숫자 타입이 달라야 오버로딩 성립됨
	//this:생성자,메소드,인스턴스필드 다 가리킴
	Car(String model, String color){
		//this.model = model;
		//this.color = color;
		this(model, color, 350);//이 형태는 생성자를 뜻함 ()만 붙이면 생성자.
		//동일한 형태의 생성자를 호출함(ex.아래 생성자를 호출함)
	}
	
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}

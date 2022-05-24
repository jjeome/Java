package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {
		System.out.println("pi: "+Planet.pi);
		//Planet.pi = Math.pi; //final로 값을고정을 했기 때문에 변경 x, 누구나 접근은 가능
		
		Planet earth = new Planet(6400);//생성자를 통해 처음 한번 값을 줄수있음
		System.out.println("earth: " + earth.radius);
		//earth.radius = 6000; -> 오류남
		
		Planet moon = new Planet(1500);
		System.out.println("moon: " + moon.radius);
	}

}

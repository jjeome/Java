package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000);
		Subway green = new Subway("2호선", 1500);
		Bus bus = new Bus("309번", 1300);
		
		hong.take(green);
		hong.take(bus);
		
		hong.showInfo();
		green.showInfo();
		bus.showInfo();
	}

	
	
	//
}

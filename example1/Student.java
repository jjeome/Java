package com.yedam.example1;

public class Student {
	//필드 - 이름/돈
	private String name;
	private int money;
	private String bus;
	
	//생성자 - 값을 초기화
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	
	//메소드 - 돈 지불
	public void take(Subway subway) {
		int pay = subway.getPay();
		this.money -= pay;
		subway.take(pay);
	}
	
	public void take(Bus bus) {//오버로딩
		int pay = bus.getPay();
		this.money -= pay;
		bus.take(pay);
	}
	
	public void showInfo() {
		System.out.println(name +"님의 남은 돈은 "+money+"원 입니다.");
	}
	
	
}

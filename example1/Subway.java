package com.yedam.example1;

public class Subway {
	//필드 - 지하철 호선, 누적금액, 누적승객수, 비용
	private String lineNumber;
	private int money;
	private int passCount;
	private int pay;
	
	//생성자
	public Subway(String lineNnumber, int pay) {
		this.lineNumber = lineNnumber;
		this.pay = pay;
	}
	
	//메소드 - 
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passCount++;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + "의 승객은 "+passCount+"명 이고, 수입은 "+money+"원 입니다.");
	}
}

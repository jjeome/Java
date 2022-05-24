package com.yedam.example1;

public class Bus {
	private String busNum;
	private int money;
	private int pay;
	private int passCount;

	public Bus(String busNum, int pay) {
		this.busNum = busNum;
		this.pay = pay;
	}
	
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passCount++;
	}

	public void showInfo() {
		System.out.println(busNum+"의 승객은 "+passCount+"명 이고, 수입은 "+money+"입니다.");
	}
	
	
}

	

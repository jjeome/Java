package com.yedam.java.example1;

/* Gold클래스
	- 고객아이디, 이름, 등급, 보너스 포인트, 보너스 포인트 적립율, 할인율
	- 기본 등급 : GOLD
	- 보너스 포인트 적립율 : 2%
	- 할인율 : 10%
*/
public class Gold extends Customer{
	double disCount;
	
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.bonusRatio = 0.02;
		this.disCount = 0.1;
		this.customerGrade = "GOLD";
	}
	
	@Override
	public int calcPrice(int price) {
		//1. 보너스 포인트 적립
		this.bonusPoint += price * this.bonusRatio;
		//2. 할인율이 적용된 가격
		return (int)(price * (1-this.disCount));
	}
	
	public void setDisCount(double discount) {
		this.disCount = discount;
	}
	
	public double getDisCount() {
		return disCount;
	}
	
	

}



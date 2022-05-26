package com.yedam.java.example1;

public class VIP extends Customer {
	double saleRatio;
	String counSelor;
	
	public VIP(int customerId, String customerName, String counSelor) {
		super(customerId, customerName);
		this.saleRatio = 0.15;
		this.bonusRatio = (int) 0.05;
		this.counSelor = counSelor;
		this.customerGrade = "VIP";
	}
	
	@Override
	public int calcPrice(int price) {
		//메소드 안에서 정의한 변수는 메소드 안에서만 사용가능
		//int bonusPoint와 bonusPoint 둘 다 쓸 때 this.bonusPoint라고 써야함
		//아닐 때는 this 안써도 됨.
		//this는 
		//int bonusPoint = 0;
		bonusPoint += price * bonusRatio;
		return price - (int)(price*bonusRatio);
	}
	
	@Override
	public String showInfo() {
		return super.showInfo()+"\n"+"담당 상담원은 "+counSelor+"입니다.";
	//super : super.필드 super.메소드 super.생성자 다 됨.
	//super자체가 부모클래스를 가리키는 것.
	}
	
	public void setCounSelor(String counSelor) {
		this.counSelor = counSelor;
	}
	
	public String getCounSelor() {
		return counSelor;
	}
	
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}
	
	
}

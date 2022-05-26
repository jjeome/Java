package com.yedam.java.example1;

public class Customer {
	//필드
	int customerId;//고객 아이디
	String customerName;//고객 이름
	String customerGrade;//고객 등급
	int bonusPoint;//보너스포인트
	double bonusRatio;//보너스 포인트 적립율
	
	//생성자
	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	//메소드
	//포인트 출력
	public int calcPrice(int price) {
		this.bonusPoint += (price * this.bonusRatio);
		return price;
	}
	//정보출력
	public String showInfo() {
		return customerName + "님의 등급은 "+customerGrade + "이며, 보너스 포인트는 "+bonusPoint+"입니다.";
	}
	
	public void setCustomerID(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerID() {
		return customerId;
	}
	
	public void setCustomrName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	public String getCustomerGrade() {
		return customerGrade;
	}
	
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	public double getBonusRatio() {
		return bonusRatio;
	}
	
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public int getBonusPoint() {
		return bonusPoint;
	}
}

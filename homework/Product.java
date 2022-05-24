package com.yedam.homework;

//상품에 대한 정보를 가지는 클래스
public class Product {
	//필드 - 상품명, 가격
	private String name;
	private int price;
	
	//생성자
	public Product() {}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	//메소드
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	//제품별 가격 출력
	public void showInfo() { //->이거나 위에꺼나 사용하기.
		System.out.println(name + ":"+ price);
	}
}

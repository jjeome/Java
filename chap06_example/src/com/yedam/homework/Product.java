package com.yedam.homework;

//상품에 대한 정보를 가지는 클래스
public class Product {
	//필드 - 상품명, 가격
	private String name;
	private int price;
	
	//생성자
	public Product() {} //default 생성자는 setter로 값을 초기화 및 수정 해야함.
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	} // 초기화 시킨 생성자는 getter로 조회만 하면 됨.
	
	
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
	
	/*제품별 가격 출력
	public void showInfo() { 
		System.out.println(name + ":"+ price);
	}
	*/
}

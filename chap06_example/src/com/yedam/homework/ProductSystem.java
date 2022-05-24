package com.yedam.homework;

//1.상품 수 입력
//2.상품 및 가격 입력
//3.제품별 가격 출력
//4.분석
public class ProductSystem {
	private Product[] list;
	private int index;

	public ProductSystem() {
		index = -1;
	}

	// 1. 상품 수 입력
	public void setListSize(int size) {
		list = new Product[size];
	}

	// 2. 상품 및 가격 입력
	public void putProduct(String name, int price) {
		Product product = new Product();// 들어올 값 담기위한 임시변수
		product.setName(name);
		product.setPrice(price);

		list[++index] = product;
	}

	// 3.제품별 가격 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			Product product = list[i];// product의 필드값 어떻게 출력할것인가?
			System.out.println(product.getName() + ":" + product.getPrice());
			list[i].showInfo();
		}

	}

}

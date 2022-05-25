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
			//list[i].showInfo();
		}

	}
	
	// 4. 분석 - 최고가격 제품
	Product printMax() {
		Product test = new Product();
		String maxName = null;
		int max = list[0].getPrice();
		
		for(int i=0; i <= index; i++) {
			if(max < list[i].getPrice()) {
				max = list[i].getPrice();
				maxName = list[i].getName();
			}
			
		}
		test.setName(maxName);
		test.setPrice(max);
		return test;
	}
	
	//4.분석 - 총합 -> 최고가격이 1개라는 전제하에 총합구하기.
	int printSum() {
		int sum = 0;
		int result = 0;
		for(int i=0; i<=index; i++) {
			sum += list[i].getPrice();
		}
		result = (sum - printMax().getPrice());//총합에서 최고가격을 제외하는건 한번만 뺀다는것.
		return result; //만약 최고가격이 2개이상이면 몇개를 제외할건지 정해야함.
	}

}

package com.yedam.java.example1;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customer = new Customer(456, "주은하");
		customer.calcPrice(5000);
		System.out.println(customer.showInfo());
		
		Gold gold = new Gold(123, "최현정");
		gold.calcPrice(3000);
		System.out.println(gold.showInfo());
		
		VIP vip = new VIP(978, "서선규", "윤상혁");
		vip.calcPrice(10000);
		System.out.println(vip.showInfo());
		
		
	}

}

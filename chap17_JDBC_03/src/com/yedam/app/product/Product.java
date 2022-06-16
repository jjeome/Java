package com.yedam.app.product;
//VO class
public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return "제품번호 : "+productId+", 제품이름 : "+productName+", 제품가격 : "+productPrice;
	}
	
	
}

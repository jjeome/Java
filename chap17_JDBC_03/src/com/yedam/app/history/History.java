package com.yedam.app.history;

public class History {
	//2개의 값만 입력받도록
	//1:입고 2:출고
	private int productId;
	//productCategory
	private int productCg;
	//productAmount
	private int productAmt;
	
	
	//toString 별도로 안함
	
	
	//getter,setter
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductCg() {
		return productCg;
	}
	
	public void setProductCg(int productCg) {
		this.productCg = productCg;
	}
	
	public int getProductAmt() {
		return productAmt;
	}
	
	public void setProductAmt(int productAmt) {
		this.productAmt = productAmt;
	}






}

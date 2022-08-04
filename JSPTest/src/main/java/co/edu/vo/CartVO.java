package co.edu.vo;

public class CartVO {
	private int num;
	private String productNm;
	private int price;
	//단가
	private int qty;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productName) {
		this.productNm = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}

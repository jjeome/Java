package com.test.common;

// 정수형, 문자형 값 지정후 서블릿을 목적으로 공유 가능하게끔.
public class ShareObject {
	private int count;
	private String str;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	
}

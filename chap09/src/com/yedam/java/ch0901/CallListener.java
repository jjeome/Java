package com.yedam.java.ch0901;

public class CallListener implements Button.OnClickListener{//버튼 내부에 있는 인터페이스

	@Override
	public void onClick() {
		System.out.println("Calling");
	}
	
}

package com.yedam.java.ch0901;

public class Button {
	
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	//버튼이라는 클래스를 사용하고 싶은데, 어떤기능인지 보다 구제척으로 해주기 위해 내부에 인터페이스.
	//중첩인터페이스 : 내부에서만 사용함.
	static interface OnClickListener{//보다 강제성을 띄우기 위해서 내부에 인터페이스를 만들어주는것.
		void onClick(); 
		
	}
}

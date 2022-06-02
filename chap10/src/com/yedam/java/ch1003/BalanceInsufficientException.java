package com.yedam.java.ch1003;
//예외클래스는 반드시 최상위 클래스인 Exception을 상속 받아야함
public class BalanceInsufficientException extends Exception{ //잔액부족 예외
	//예외클래스는 보통 생성자 2개 만듦
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}

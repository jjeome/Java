package com.yedam.java.ch1003;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public long withDraw(int money) throws BalanceInsufficientException {
		//출금기능
		if(balance < money) {
			//예외를 일으키기 -> 예외클래스를 생성한다는 것.
			//throw를 붙이면 강제로 예외라고 지정해주는 것.(예외 발생시킴)
			//예외가 발생하면 예외 뒤에껀 절대 실행 X -> 자바가 예외 인식함
			//메소드를 호출한 곳으로 떠넘김 (throw)
			//try-catch는 문법적으로 틀리진 않지만 throw를 쓰는 이유는
			//처리를 할 때 외부에서 처리하도록 유도하기위해서.
			throw new BalanceInsufficientException("잔고 부족 : "+(money - balance)+" 모자랍니다.");
		}
		balance -= money;
		return balance;
	}
}

package com.yedam.java.example1;

public interface Scheduler {//인터페이스로 사용하는 방법 정의
	// 직원이 고객을 할당 받는 방식(응대)
	public void getNextCall();
	// 관리자가 직접 대기열을 관리
	public void sendCallToAgent();
}

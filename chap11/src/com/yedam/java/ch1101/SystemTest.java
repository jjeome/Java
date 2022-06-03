package com.yedam.java.ch1101;

public class SystemTest {
	//시간 가져오는 메소드
	public static void main(String[] args) {
		long time1 = System.nanoTime(); //실행하기 전 시간을 저장
		int sum = 0;
		for(int i=1; i<=10000000; i++) {
			sum += 1;
		}
		long time2 = System.nanoTime();
		System.out.println("1~10000000까지의 합 : "+sum);
		System.out.println("계산에 "+(time2-time1)+"나노초가 소요되었습니다.");
	}

}

package com.yedam.java.ch1502;
//숫자 가늠하고 비교.
public class Util {
	
	//숫자클래스의 최상위 클래스는 number
	//와일드 카드
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
		
	}
}

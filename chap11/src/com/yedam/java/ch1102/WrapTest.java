package com.yedam.java.ch1102;

public class WrapTest {

	public static void main(String[] args) {
		//boxing
		Integer obj1 = new Integer(100); 
		Integer obj2 = Integer.valueOf("100"); //문자열도 숫자 포맷이면 공식적인 boxing가능
		Integer obj3 = 100; //정수타입의 상수를 입력하면 알아서 boxing 함
		
		//unboxing
		int val2 = obj2.intValue(); //wrapper클래스에서 제공하는 공식적인 unboxing메소드(값을 끄집어내는)
		int val3 = obj3; //(obj3)는 integer클래스 그래서 int와 integer는 거의 동일하게 사용 가능
		int result = obj2 + val3; //대응되는 타입이 같아야 가능함
		
		//값 비교
		Integer object1 = 300; //값을 공유하지 않고 각각의 개별 instance를 만들어냄 -> 등호연산자로 보면 다른 인스턴스로 안자험
		Integer object2 = 300;
		
		System.out.println("== 결과 : "+(object1 == object2)); 
		System.out.println("언박싱 후 == 결과 : "+(object1.intValue()==object2.intValue()));//변수가 똑같은 객체인지 비교
		//class타입으로 비교를 할 때엔 equals가 좋음.
		System.out.println("equls() 결과 : "+(object1.equals(object2)));
	}

}

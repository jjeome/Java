package com.yedam.java.ch1601;

public class RamdaTest {

	public static void main(String[] args) {
		//메소드 시그니처에 따라 다르게 표현되는 람다식
		//람다식 - 익명구현객체를 간소화
		
		// 1. 매개변수, 리턴타입 X
		MyFunInterfaceA fa = () -> { 
			String str = "method call1"; 
			System.out.println(str); 
		};
		fa.method(); //호출 시 그냥 변수이름 쓰면 됨
		
		fa = () -> { System.out.println("method call2"); };
		fa.method();

		//간단하게 표현하자면,
		fa = () -> System.out.println("method call3");
		fa.method();
		
		
		// 2. 매개변수O, 리턴타입X
		MyFunInterfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fb.method(5);
		
		//타입 무시하고 변수하나만 땡겨쓸 수 있음
		//람다식은 그냥 이름만 붙여주면 알아서 함
		fb = (x) -> {System.out.println(x*5);};
		fb.method(7);
		
		//화살표 하나만으로 메소드 정의 가능. 람다식 간소화
		fb = x -> System.out.println(x*5);
		fb.method(10);
		
		
		// 3. 매개변수O, 리턴타입O
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result; //메소드 내에 return구문 넣기
		};
		System.out.println(fc.method(1,2));
		
		fc = (x, y) -> { return x+y; }; //return구문에 표현식을 넣어 바로 반환해도 됨
		System.out.println(fc.method(1,5));
		
		//실행구문이 리턴구구문만 있을 경우, return과 실행구문 생략해 표현식만 해도 ㄱㅊ
		fc = (x,y) -> x+y; 
		System.out.println(fc.method(6,5));
		
		//return구문을 이용해 기존에 존재하는 메소드를 호출할때도 가능
		fc = (x,y) -> {
			return Math.max(x,y);
		};
		//위의 리턴구문만 남겨 함수로 바로 넘겨주기 가능함
		fc = (x,y)-> Math.max(x,y);
		System.out.println(fc.method(10,12));
		
		
		//람다식은 따라서 변수 값을 변경 못하게 함
		int val1 = 10;
		int val2 = 20;
		
		//가지고 있는 값을 가지고 오는거지 주소를 들고오는 것이 아님(연결상태 X 값만 가져옴)
		//상수를 요구하는 것이 아니라 변수값을 더한걸 요구
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};

		//람다식 외부 변수는 final특성을 가짐 -다른곳에서 변수를 또 건드리면 람다식내에서 오류발생
		//val1 = 100;
		fa.method();
		
		
	}

}

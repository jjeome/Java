package chap02;
/*
 * 데이터타입을 다른 타입으로 변환
 * 강제형변환
 * 자동형변환
 * 
 * String <-> 기본 데이터형 (int, double, short---등)
 */

public class 타입변환 {

	public static void main(String[] args) {
		//자동
		int a = 100;
		long b = a;
		
		//강제
		long c =100;
		int d = (int)c;
		
		//자동
		double e = c;
		
		//강제
		double f = 5.2;
		long g = (long) f;
		System.out.println("g = "+g);
		
		double h = (double)10 / 3.0;
		System.out.println("h = "+h);
		
		System.out.println("결과는 = " +(10+20)); //String과 int는 String으로
		System.out.println(10+20+" = 결과 "); //int int String이라서 int로
		
		//int -> String
		int i = 100;
		String j = String.valueOf(i); //기본데이터타입을 String으로 바꾸기
		
		//String -> int
		String k = "100";
		int l = Integer.parseInt(k);
	}

}
























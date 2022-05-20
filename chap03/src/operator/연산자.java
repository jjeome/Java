package operator;

import java.io.IOException;
import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {
		//산술연산();
		//짝수();
		//부호연산();
		//incDesOp(); //증감연산
		//denyLogicOp();
		//toLower();
		//compareOp();
		//isDigit();
		//isChar(); //97~127 || 65~90 == 문자
		cndOp();
	}
	
	//삼항연산자 => 조건연산자
	public static void cndOp() {
		int score = 70;
		String grade = (score >= 90) ? "A등급" : (score>=80 ? "B" : "C");//작은따옴표 char하기 주의!
		
		System.out.printf("%d점은 %s입니다." , score, grade);
	}
	
	
	
	//입력값이 숫자인지 판단
	public static void isDigit() {
		try {
			int key = System.in.read();
			boolean result = (key >= 48) && (key <= 57);//숫자 아스키값
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//입력값이 문자인지 판단
	public static void isChar() {
		try {
			int key = System.in.read();
			boolean result = (key >= 65 && key <= 90) || (key>=97 && key<=122);//문자 아스키값
			String str = result ? "문자" : "문자 아님";
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//비교연산
	public static void compareOp() {
		int year = 2020;
		boolean result = (year%4 == 0 && year%100 != 0) || (year%400 == 0);
		
		System.out.println(result);
	}
	
	
	//문자연산
	public static void toLower() {
		char c = 'A';
		char p = (char)(c+32); //int로 나오는 결과 강제형변환 시키기 , 소문자 a구하기
		System.out.println(c+":"+p);
	}
	
	
	//논리부정
	public static void denyLogicOp(){
		boolean play = true;
		play = !play;
		
		System.out.println(play);
	}
	
	
	//증감연산자
	public static void incDesOp() {
		int x = 10;
		int y = 10;
		
		--x; // == x = x-1
		++y; //  
		
		System.out.println(x);
		System.out.println(y);
		
		int a = 10;
		int b = 10;
		int c= ++a + ++b;
		System.out.println(c);
	}
	
	//부호연산자
	public static void 부호연산() {
		int i1 = +100;
		int i2 = -100;
		
		byte x = 100;
		int result = -x;
	}
	
	
	//짝수 
	public static void 짝수() {
		int n1 = 4;
		boolean result = n1%2 == 0;
		System.out.println(result);
	}
	
	//산술연산자
	public static void 산술연산() {
		int n1 = 10;
		int n2 = 3;
		
		int n3 = n1/n2; //몫
		int n4 = n1%n2; //나머지
		
		System.out.println(n3 + ":" + n4);	
	}

	
}

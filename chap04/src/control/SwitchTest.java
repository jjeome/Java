//int,, char, String, 연산식 switch ()에 들어갈 수 있음
package control;

import java.util.Scanner;

public class SwitchTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//test1();
		//test2();
		test3();
	}
	
	public static void test3() {
		int score = scan.nextInt();
		switch(score/10) {
		case 10:
		case 9:
			System.out.println("A 등급");
			break;
		case 8:
			System.out.println("B 등급");
			break;
		case 7:
			System.out.println("c 등급");
		default:
			System.out.println("D 등급");
		}
	}
	
	public static void test1(){
		String menu = scan.next();
		
		switch (menu) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");
		}
	}
	
	public static void test2() {
		int menu = scan.nextInt();
		//1-5 평일 6,7 주말
		switch(menu) {
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 :
			System.out.println("평일");
			break;
		case 6 :
		case 7 :
			System.out.println("주말");
			break;
		default:
			System.out.println("1부터 7까지만 입력하세요");
		}

	}

}

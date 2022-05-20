package chap02;

import java.util.Scanner;

public class 연습문제3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String name, idNum, callNum;
		
		//이름
		System.out.print("이름: ");
		name = scan.nextLine();
		
		//주민번호
		System.out.print("주민번호 앞 6자리: ");
		int idNum1 = Integer.parseInt(scan.nextLine()); 
		
		//전화번호
		System.out.print("전화번호: ");
		int callNum1 = Integer.parseInt(scan.nextLine());
		
		System.out.printf("이름:%s \n주민번호:%s \n전화번호:%s",name,idNum1,callNum1);
	}

}

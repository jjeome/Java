package chap02;

import java.util.Scanner;

public class ScannerUtil {

	public static void main(String[] args) {
		String name;
		String job;
		int age;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : "); 
		name = scan.nextLine(); //문자열 입력
		
		System.out.print("직업 입력 : ");
		job = scan.nextLine();
		
		System.out.print("나이 입력 : ");
		age = Integer.parseInt(scan.nextLine()); //정수 실수 더블형으로 바꾸려면 변환시켜야함
		
		//입력받은 문자열 출력
		System.out.printf("이름:%s \n직업:%s \n나이:%s ", name, job, age);
	}

}

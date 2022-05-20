package control;

import java.util.Scanner;

public class Bank {

	private static Scanner scan;

	public static void main(String[] args) {
		boolean run = true;
		banner();
	}
	
	public static void banner() {
		Scanner scan = new Scanner(System.in);

		int menu = 0;
		int balance = 0;
		int input = 0;
		
		do {
			System.out.println(" ----------------------------- ");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
			System.out.println(" ----------------------------- ");
			System.out.println("선택> " );
			menu = scan.nextInt();
			
			if (menu == 1) {
				System.out.println("예금액> " );
				input = scan.nextInt();
				balance += input;
				System.out.println("예금되었습니다!");

			} else if (menu == 2) {
				System.out.println("출금액> " );
				input = scan.nextInt();
				balance -= input;
				System.out.println("출금되었습니다!");

			} else if (menu == 3) {
				System.out.println("잔액> " + balance);
				System.out.println("잔액입니다!");

			} else if (menu==4) {
				break;
			}
		} while(true);
			System.out.println("프로그램을 종료합니다!");
	}
}

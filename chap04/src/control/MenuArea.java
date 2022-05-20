package control;

import java.util.Scanner;

/*
 * 1이면 "사각형"출력
 * 2이면 "삼각형"출력
 * 0이면 종료
 */
public class MenuArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int menu = Integer.parseInt(scan.nextLine());
		String result;
	
		do {	
			if(menu == 1) {
				result = "사각형";
			} else if (menu == 2) {
				result = "삼각형";
			} else {
				result = "다시입력하세요.";
			}
			
			if(menu == 0) {
				result = "프로그램 종료";
				break;
			}
			
			/*if(menu == 0) {
				System.out.println("프로그램 종료.");
				break;
			}*/
			
			System.out.println(result);
			
		} while(true);
		System.out.println(result);
	}
}

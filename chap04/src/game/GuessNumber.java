package game;

import java.util.Scanner;

public class GuessNumber {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int random = (int) (Math.random()*10)+1; //컴퓨터 랜덤값
		int num[i] = new int[10]; //내가 입력하는 값
		String result;
		int count = 0;
		// 숫자끼리 비교 맞으면 종료
		do {
			count++;
			
			num[i] = scan.nextInt();
			
			if (random > ) {
				result = "크다";
			} else if (random < num){
				result = "작다";
			} else {
				result ="맞다";
			}
	
			if(count >= 5) {
				break;
			}
			
			System.out.println(result);
		} while(true);	
		System.out.println("프로그램 종료");
	}

}

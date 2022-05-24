package game;

import java.util.Scanner;

public class GuessNum {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int random = (int) (Math.random() * 100) + 1;
		System.out.println("1~100까지의 숫자 만들기 게임!");
		System.out.println("기회는 총 10번입니다.");
		System.out.println("그럼 시작!");
		int[] num = new int[10];
		int count=0;
		
		for (int i = 0; i < 10; i++) {
			count++;
			num[i] = scan.nextInt();
			
			if (random > num[i]) {
				System.out.println("Player가 입력한 수: "+num[i]);
				System.out.println("틀렸습니다.");
				System.out.println("수가 낮습니다.");
				System.out.println("남은 횟수는: "+(10-count));
			} else if (random < num[i]) {
				System.out.println("Player가 입력한 수: "+num[i]);
				System.out.println("틀렸습니다.");
				System.out.println("수가 높습니다.");
				System.out.println("남은 횟수는: "+(10-count));
			} else if (random == num[i]) {
				System.out.println("Player가 입력한 수: "+num[i]);
				System.out.println("정답입니다.");
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			if (count==10) {
				System.out.println("\n10번이 끝났습니다. \n게임을 종료합니다.");
				break;
			}
			
		}
	}

}
package array;

import java.awt.Taskbar.State;
import java.util.Scanner;

import javax.swing.text.DefaultTextUI;

public class MainApp {

	static int scores[];// 배열 타입만 선언함
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int menu;
		do {
			System.out.println("\n");
			System.out.println("1.전체출력 2.최솟값 3.최댓값 4.평균 5.종료");
			System.out.println("번호를 입력하세요.");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				arr();
				break;
			case 2:
				findMin();
				break;
			case 3:
				findMax();
				break;
			case 4:
				aveRage();
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:	
				System.out.println("1부터 5중에서 입력하세요.");
			} 
			//if(menu==5) {
			//	break;
			//}
		} while(menu!=5);
	}
	public static void arr() {// 배열 초기화 및 출력
		scores = new int[10]; // 요소 크기 지정(요소값 초기화 안해도 0으로 지정되어있음)

		for (int i = 0; i < 10; i++) {
			scores[i] = scan.nextInt();
			System.out.println(scores[i]);
		}
		// System.out.println("2번째 학생은: " + scores[1] + "점 입니다.");
	}

	// 최솟값
	public static void findMin() {
		int min = scores[0];

		for (int i = 1; i < 10; i++) {
			if (scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.printf("최솟값은 %d 입니다. \n", min);
	}

	public static void findMax() {
		// 최댓값
		int max = scores[0];
		for (int i = 1; i < 10; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.printf("최댓값은 %d 입니다. \n", max);
	}

	public static void aveRage() {
		// 평균구하기
		int sum = 0;
		double avg;
		for (int i = 0; i < 10; i++) {
			sum += scores[i];
		}
		avg = sum / 10;
		System.out.printf("평균은 %.1f 입니다. \n", (double) avg);
	}

}

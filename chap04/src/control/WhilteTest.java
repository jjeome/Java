package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhilteTest {

	public static void main(String[] args) throws FileNotFoundException {
		//1부터 10까지 반복
		//while1();
		//for1();
		//for2();
		//gugudan1();
		//findMax(); 
		//findMin();
		findMinMax();
	}
	
	public static void findMinMax() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int min = scan.nextInt();
		int max = min;
		
		for(int i = 1; i < 9; i++) {
			int num = scan.nextInt();
			if(num < min) {
				min = num;
			} else if(num > max) {
				max = num;
			}
		}
		System.out.println("최솟값 : " + min);
		System.out.println("최댓값 : " + max);
	}
	
	
	//최솟값 구하기
	public static void findMin() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int min = 100;
		
		for(int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			if(num < min) {
				min = num;
			}
		}
		System.out.println("최솟값 : " + min);
	}
	
	//최댓값 구하기
	public static void findMax() throws FileNotFoundException {
		//10번 반복해 숫자 입력받기 5보다 크면출력
		Scanner scan = new Scanner(new File("score.txt"));
		int max = 0;
		
		for(int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			if(num > max) {
				max = num;
			}
		}
		System.out.println("최댓값 : "+max);
	}
	
	
	
	//입력 단 출력하기
	public static void gugudan1() {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %d\n",dan,i,dan*i);
		}

	}
	
	
	
	public static void while1() {
		int count = 1;
		do {
			System.out.println(count);
			count++;
		} while(count<=10);
		
	}
	
	public static void for1() {
		for(int i=0; i<=10; i+=2) {
			System.out.println(i);
		}
	}
	
	public static void for2() {
		for(int i =10; i>=1; i--) {
			System.out.println(i);
		}
	}
	
}

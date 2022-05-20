package baeckjun.p2884;

import java.util.Scanner;

public class Main {
	//문제:45분 일찍 알람 설정하기
	public static void main(String[] args) {
		sangGeun();
	}
	
	public static void sangGeun() {
		Scanner scan = new Scanner(System.in);
		//상근이가 설정한 알람
		int H = scan.nextInt(); //시간
		int M = scan.nextInt(); //분침
		
		/*
		 * 1. 분단위로 바꾸기
		   2. 45빼고 시간단위로 바꾸기
		   3. 예외처리 해주기(날짜가 바뀌는 경우 - 0시보다 줄어들 경우)
		 */
		
	}

}

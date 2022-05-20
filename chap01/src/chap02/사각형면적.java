package chap02;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int w, h, area;
		
		//가로
		System.out.print("가로출력: ");
		w = Integer.parseInt(scan.nextLine());
		
		//세로
		System.out.print("세로출력: ");
		h = Integer.parseInt(scan.nextLine());
		
		//면적값
		area = w*h;
		System.out.println("면적=" + area);
		
	}

}

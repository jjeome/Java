package yedam;

import java.util.Scanner;

public class 삼각형면적 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double w, h, area;
		
		//밑변
		System.out.println("밑변: ");
		w = Double.parseDouble(scan.nextLine());
		
		//높이
		System.out.println("높이: ");
		h = Double.parseDouble(scan.nextLine());
		
		//면적
		area = (w*h)/2;
		
		System.out.printf("\n밑변 : %.2f \n높이 : %.2f \n면적 : %.2f", w,h,area);
	}

}

package baekjoon.java.q2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		int newHour;
		int newMin;
		
		if(hour == 0 && ((min>=0||min<=44)) {
			hour = 23;
			min = 60;
			newHour = hour;
			newMin = min-45;
			System.out.println(newHour+" "+newMin);
			
		// 1.분이 45-59분일때
		// 2.분이 0-44분일때 
		// 3.시가 0시이면서 0-44분일때
		} else {
			newHour = ((hour*60+min)-45)/60;
			newMin = ((hour*60+min)-45)%60;
			System.out.println(newHour+" "+newMin);
		}
		
	}

}

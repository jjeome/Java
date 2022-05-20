package control;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = Integer.parseInt(scan.nextLine());
		String result;
		if(x>=50) {
			result = "우산을 챙긴다.";
		} else {
			result = "그냥 간다.";
		}
		System.out.println(result);
	}

}

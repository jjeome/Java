package baeckjun.p10430;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		int result1 = (A+B)%C;
		int result2 = ((A%C) + (B%C))%C;
		int result3 = (A*B)%C;
		int result4 = ((A%C) * (B%C))%C;
	
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
	}

}

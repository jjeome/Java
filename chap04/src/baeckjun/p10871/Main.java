package baeckjun.p10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int x = scan.nextInt();
		int num;
		int i=1;//반복 횟수
		
		do {
			num = scan.nextInt();
			if(num < x) {
				System.out.print(num+" ");
			}
			i++;
		} while(i<=n);
	}

}

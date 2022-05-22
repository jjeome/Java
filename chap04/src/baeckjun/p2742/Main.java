package baeckjun.p2742;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Num();
	}
	
	public static void Num() {
		int naNum = scan.nextInt();
		for(int i=naNum; i>0; i--) {
			naNum -= 1;
			System.out.println(naNum);
			}
	}
}

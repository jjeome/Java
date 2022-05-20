package baekjun.p2439;

public class Main {

	public static void main(String[] args) {
		for(int i=1; i<5; i++) {
			for(int j=4; j>0;j--) {
				if(i<j) {
					System.out.println("*");
				} else {
					System.out.println(" ");
				}
			}
		} System.out.println(" ");;
	}

}

package memory;

public class MainTest {

	public static void main(String[] args) {
		if(args != null) {
			for(int i=0; i<args.length;i++) {
				sum += Integer.parseInt(args[i]);
				System.out.println(args[i]);
			}
			System.out.println("합계="+ sum);
		}
	}

}

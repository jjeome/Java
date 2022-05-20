package chap02;

public class work01 {

	public static void main(String[] args) {
		type();
	}

	public static void type() {
		char grade = '상';
		String schoolName = "예담";
		int score = 85;
		double average = 4.235;
		int flag = 0b10000000;
		char firstChar = '\uAC00';
		char secondChar = 0xAC01;
		int salary = 1_000_000;
		boolean useYn = true;
		
		System.out.println("grade = " + grade + ", schoolName = " + schoolName +", score = "+ score);
		System.out.println("average = " + average);
		System.out.println("flag = " + flag);
		System.out.println("firstChar = " + firstChar);
		System.out.println("secondChar = " + secondChar);
		System.out.println("salary = " + salary);
		System.out.println("useYn = " + useYn);
	}
}

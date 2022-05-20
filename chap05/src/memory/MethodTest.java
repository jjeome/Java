package memory;

public class MethodTest {

	public static void main(String[] args) {
		test1("#", 20);
		test1("X", 5);
		test1("X@", 10);
	}
	public static void test1(String s, int length) {
		for(int i=0; i<length; i++) {//위 string int로 인수를 받아서 설정
			System.out.print(s);
		}
		System.out.println();
	}
}

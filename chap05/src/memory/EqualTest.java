package memory;

public class EqualTest {

	public static void main(String[] args) {
		int[] a = new int[10]; //배열은 처음에 0으로 초기화됨
		int[] b = a;// 얕은복사 : 주소값만 복사하는
		int[] c = new int[a.length];
		System.arraycopy(a, 0, c, 0, a.length); //깊은복사
		
		b[0] = 100;
		
		System.out.println(a[0]);
		System.out.println(a == b);
		
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2)); //equals는 값을 비교
		
		String s3 = "hi"; // 메소드 영역의 상수 hi를 s3,s4가 같이 참조하고 있음
		String s4 = "hi";
		System.out.println(s3 == s4);
		
		s1 = null;
		s2 = null; //아무것도 참조하지 않는 값 널값.
}
	
}

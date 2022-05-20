package chap02;

import java.io.IOException;

public class 입출력 {

	public static void main(String[] args) throws IOException {
		String korName = "국어";
		String engName = "영어";
		String avgName = "평균";
		
		int kor = System.in.read();
		int eng = System.in.read();
		double avg = (kor+eng)/2.0;
		
		//System.out.println("국어는 = " + kor + ", 영어는 = " + eng);
		System.out.printf("%s는 = %d\n%s는 = %d\n평균 = %4.1f", korName, kor, engName, eng, avg);
	}

}

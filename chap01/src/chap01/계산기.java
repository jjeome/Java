package chap01;

/*
 * 작성자 : 최현정
 * 작성일자 : 2022-05-18
 * 기능 : 숫자 계산기 
 */

public class 계산기 {

	public static void main(String[] args) {
		//add(); // 두 수의 합
		//sub(); // 두 수의 뺄셈
		
		// 국 영 수 합계, 평균 출력
		totalAvg();
	}
	
	public static void add() {
		int num1 = 1; //변수 선언 후 값 저장
		int num2 = 2;
		
		num1 = 10; //num1 변수 변경 값 저장
		
		int result = num1+num2; // result변수에 두 변수 더한 값 저장
		
		System.out.println(result); 
	}
	
	public static void sub() {
		int x = 1;
		int y = 2;
		int result = x-y;
		System.out.println(result);
	}
	
	public static void totalAvg() {
		int math = 100; //변수 선언 및 초기화
		int kor = 70;
		int eng = 80;
		
		int result = math+kor+eng; //국영수 합계
		double avg = (double)result/3; //평균 (double)강제형변환
		
		System.out.println("합계 = " + result);
		System.out.println("평균 = " + avg);
	}

}





// 줄맞춤 (ctrl+shift+f)

package chap02;
/*
 * 변수의 타입(유형)
 * 변수 - 메모리의 저장위치. 값을 저장하는 공간
 * 유형 - 메모리에 값을 저장하는 형식(구조와 크기가 다름)
 *            2      2      4      8
 * 숫자 : 정수 byte < short < int < long < BigDecimal
 *           127    3만2천  21억   10^18
 *           
 *       실수 float  < double  유효자릿수  정밀도
 *          유효자릿수   유효자릿수
 *           7자리      15자리
 *           
 * 문자 : 한 글자  -char = 'A' '가' 
 *       단어    -String = "이름"
 *       
 * 날짜
 * 불린형 - boolean : true or false
 */
public class 변수 {

	public static void main(String[] args) {
		//숫자
		int korScore = 128; // 상수값 기본형 int
		long rich = 220000000l; // 상수값 long 사용시 숫자 맨 끝에 l or L 써야함
		float avg = 0.123456789f; //float형 변수 avg를 선언하고 상수값 84.5를 변수에 저장                       
		                          //f가 없으면 double
		double totalAvg = 0.12345678901234567;
		int engScore = 10;
		int mathScore; //변수 선언
		mathScore = 100; //변수 초기화
	
		/*
		System.out.println(avg);
		System.out.println(totalAvg);
		System.out.println(engScore);
		*/
		
		
		//정수 리터럴
		int int2 = 0b11111111; //2진수 표현
		int int8 = 017; //8진수 표현
		int int16 = 0x7F; //16진수 표현
		
		System.out.println("int2 = "+int2);
		System.out.println("int8 = \" "+ int8 +" \"");
		System.out.println("int16 = \\"+int16 +"\\");
		
		
		
		//문자
		char grade = '가';
		String grade2 = "A+";
		
		/*
		System.out.println("grade = " + (int)grade);
		char code = 44033; //유니코드의 숫자
		System.out.println("44033 문자 = "+code);
		*/
		
		
		//불린형
		int k = 60, e = 60, m = 60;
		boolean passYn = true;
		boolean fail = k>50 && e>50 && m>50;
		
		//System.out.println("fail = " + fail);
		
		
	}
}















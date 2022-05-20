package chap01;

public class Hello {

	public static void main(String[] args) {
		// 영어로 인사
		greetEn(); //메서드 호출
		
		// 한글로 인사
		greet();
		
		// 자기 이름
		info();	
	}
	
	
	//greetEn : 메소드명
	//메서드 선언
	public static void greetEn() {
		System.out.println("hello");
	}
	
	
	public static void greet() {
		System.out.println("안녕");
	}
	
	
	public static void info() {
		System.out.println("최현정");
	}

}


/*
ctrl d  한줄삭제
ctrl + 확대  -축소
sysout + (ctrl+ spacebar : 입력자동장치)
alt + 방향키
*/

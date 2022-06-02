package com.yedam.java.ch1002;
//try-catch문
public class MainTest {

	public static void main(String[] args) throws ClassNotFoundException {
		//try-catch문 : try {} catch(Exception e) {} finally {}
		try {
			//원래 실행하고자 한 코드
		} catch(Exception e){
			//예외 발생한 경우 처리코드
		} finally {
			//정상적으로 실행 하든 예외가 발생했든 반드시 실행되야 하는 경우
		}
		
		String data1 = null;
		String data2 = null;
		
		try {
			int value1 = Integer.parseInt(data1);
			
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			//catch구문이 catch하는 것은 try로 묶은 코드들만 처리함
			//예외 클래스가 가지고 있는 오류를 출력하게 하는 것 : e.printStackTrace();-> 빨간오류로 뜨니까 잘 안씀
			System.out.println("실행 매개값의 수가 부족합니다.");
			return; //그냥 종료하고시으면 return을 사용하면 됨 - 어느 메소드든 다 사용이 가능함. 최소한의 처리.
		} catch(NumberFormatException e) { //다중catch문 : 필요에따라 만들어주면 됨
			System.out.println("숫자 형식에 맞춰 입력해주세요");
			return;
		} catch(Exception e) { // Exception - 최상위예외 그외에 발생하는 예외는 여기서 다 처리함
			System.out.println("기타"); // Exception은 항상 맨 마지막에 넣어줘야함!!!
			return; //항상 마지막에 return을 넣어줌:반드시 처리해야 할 부분이 있으면 finally를 넣음
		} finally { //무조건 실행되는 구문-자원을 정리할 때 사용(ex.램, 통신)
			System.out.println("필수 구문");
		}
		
		System.out.println("메인 메소드 종료");
	
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		findClass();
	}
	
	public static void findClass() throws ClassNotFoundException, NullPointerException {
		//문법적으론 상관없지만 반드시 예외처리를 해줘야하는 경우가 있음
		//class에 대한 메타정보를 가진 class - 풀네임으로 접근할 수 있음
		//new연산자를 이용해 인스턴스를 가지는 게 아님.
		//그냥 String class자체에 대한 정보만 가짐
		//반환하는건 class타입이고 출력하는건 문자열타입
		//try-catch를 이용해 처리, 예외떠넘기기:throws 
		Class clazz = Class.forName("java.lang.String");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

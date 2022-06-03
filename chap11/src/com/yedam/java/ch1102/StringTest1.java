package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {
		//byte -> String
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		//컴퓨터끼리는 byte로 오고가지만, 개발자가 볼 땐 문자열로 받아야 해서 바꿔줄 수 있음
		String str1 = new String(bytes);
		System.out.println(str1);
		
		//(타입을 기준으로, index 6부터, 4개를 가지고옴)
		String str2 = new String (bytes, 6, 4);
		System.out.println(str2);
		
		System.out.println();
		
		//String -> byte -> String
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes(); //배열을 만들어 저장함
		System.out.println(bytes1);
		String strs1 = new String(bytes1);
		System.out.println(strs1);
		
		try { //어떤 기준으로 저장할건지를 괄호안에 적어주기
			//인코딩과 디코딩할때 균일한 기준을 잡아줘야함
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println(bytes2);
			//똑같이 디코딩한다는 것을 지정해줘야함
			//지정해주지 않으면 글자 다 깨짐
			String strs2 = new String(bytes2);//, "EUC-KR");
			System.out.println(strs2);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		System.out.println();
	
		//charAt메소드 : 문장, 단어로 된 String에서 한 글자만 가져오는 것
		String ssn = "010435-2334523";
		char gender = ssn.charAt(7);//7번째 자리
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
		//for(int i=0; i<ssn.length(); i++) {
		//	System.out.println(ssn.charAt(i));
		//}
		
		
		System.out.println();
		//String 타입에서 String끼리 비교할 때 등호연산자 말고 equals 쓰기
		String val1 = "신민철"; //자바가 인스턴스 자동으로 만들어줌 
		String val2 = "신민철"; //새로운 인스턴스 만들지 않음 -> 기존의 똑같은 값을 가지고 있는 인스턴스가 있으면 걔를 공유해줌
		String val3 = new String ("신민철"); //새로운 인스턴스가 필요하다면 new연산자를 쓰면 다른인스턴스를 만들어냄
		
		if(val1.equals(val2)) {
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		
		if(val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		
		if(val1 == val2) {
			System.out.println("val1과 val2는 같은 인스턴스 입니다.");
		} else {
			System.out.println("val1과 val2는 다른 인스턴스 입니다.");
		}
		
		if(val1 == val3) {
			System.out.println("val1과 val3는 같은 인스턴스 입니다.");
		} else {
			System.out.println("val1과 val3는 다른 인스턴스 입니다.");
		}
		
		
		//index0f : 문장안에서 내가 지정한 단어가 어느위치에 있는지 찾는 메소드
		//        : 반환하는게 정해져있음 그 값이 0보다 크면 찾는 단어가 있다는 뜻
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바")!= -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}
		
		
		//substring : 불필요한 부분 짜집기
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		
		//생년원일만 빼내기
		String ssn1 = "880815-1234567";
		System.out.println("생년원일 : "+ ssn1.substring(0, 6));
		System.out.println("개별정보 : " + ssn1.substring(7));
		
		//length
		String[] temp = {"1", "2"};
		int val = temp.length;

		System.out.println(ssn1.length());
		
		System.out.println();
		
		//replace : 원본데이터 자체를 건드리는 것이 아님. 대체해서 수정
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr+" -> "+ newStr);
	}

}

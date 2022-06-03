package com.yedam.java.ch1102;

public class StringTest2 {

	public static void main(String[] args) {
		//toLowerCase & toUpperCase
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		
		if(val1.equals(val2)) {
			System.out.println("val1과 val2는 같은 값입니다.");
		} else {
			System.out.println("val1과 val2는 다른 값입니다.");
		}

		//대소문자 구분없이 값을 비교
		if(str1.equalsIgnoreCase(str2)) { 
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		
		//trim : 앞뒤 공백 제거 기능(중간은 안됨)
		System.out.println();
		String subject = "        자바     프로그래밍            ";
		String newData = subject.trim();
		String data1 = newData.substring(0, 2);
		String data2 = newData.substring(newData.indexOf("프로그래밍"));
		String result = data1 + " " + data2;
		System.out.println(newData);
		System.out.println(result);
		
		
		//valueOf
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		
		String value4 = "" + 100;
		
	}

}

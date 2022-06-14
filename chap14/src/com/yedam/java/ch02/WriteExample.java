package com.yedam.java.ch02;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("D:/dev/temp/test7.txt");
		
		//기본단위는 문자
		//한글자씩 내보내는 형태
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a);
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		

		//char배열로 한꺼번에 내보내는 형태
		writer = new FileWriter("D:/dev/temp/test8.txt");
		char[] arr1 = {'A','B','C'};
		
		writer.write(arr1);
		
		writer.flush();
		writer.close();
		
		
		//배열의 크기로 일부분만 내보내는 형태
		writer = new FileWriter("D:/dev/temp/test9.txt");
		char[] arr2 = {'A','B','C','D','E'};
		
		writer.write(arr2,3,2); //3번째 자리부터 3개만
		
		writer.flush();
		writer.close();
		
		
		writer = new FileWriter("D:/dev/temp/test10.txt");
		//char타입이던 string타입이던 가능
		String str1 = "ABCDE\n";// \n(줄바꿈)이 문자열
		String str2 = "abced";
		
		//통째로 보내기
		writer.write(str1);
		//배열 형태로 지정한 index부터 몇개까지 라는 개념으로 접근
		writer.write(str2, 3, 2);
		
		writer.flush();
		writer.close();
		
		
		
		
		
		
		
		
		
	}

}

package com.yedam.java.ch02;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws Exception{
		//String은 읽어들일 때 string으로 읽지 못함 -> 자르는 기준이 없기 때문에. 글인지 문단인지 모르기때문에.
		//char타입은 크기가 2byte이기 때문에 읽을 수 있음
		//입력받을땐 string으로 안받음
		Reader reader = new FileReader("D:/dev/temp/test7.txt");
		
		while(true) {
			//한글자씩 읽을때
			//리턴되는 타입이 내가 읽어들일 값
			int data = reader.read();
			if(data == -1) break;
			//int 타입으로 읽을 수 없기 때문에 char타입으로 강제로 변환해야 문자로 볼 수 있음
			System.out.println((char)data);
		}
		reader.close();
		System.out.println();
		
		
		//문자 기반의 stream으로 읽어옴 -> 출력하는데는 크게 문제 없음
		//문자 기반 stream은 2바이트를 읽어오기 때문에 읽어오는데 상관X
		reader = new FileReader("D:/dev/temp/test1.db");
		
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println(data);
		}
		reader.close();
		System.out.println();
		
		//char타입인 배열의 크기를 정해서 읽어오기
		reader = new FileReader("D:/dev/temp/test8.txt");
		char[] buffer = new char[100];//한번에 읽어들어올 크기가 [n]개
		while(true) {
			int readCharNum = reader.read(buffer);//배열을 넘기게 되면 리턴되는게 갯수. 
			if(readCharNum == -1) break;
			//배열 자체가 string타입이기 때문에 casting변환 안해줘도 됨
			for(int i=0; i<readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		reader.close();
		System.out.println();
		
		
		reader = new FileReader("D:/dev/temp/test10.txt");
		//char타입 기본값 = 공백(기본 설정된 배열 크기에 맞춰 기본값이 들어감)
		int readCharNum = reader.read(buffer, 5, 10);
		for(int i=0; i<(5+readCharNum); i++) {
			System.out.print(buffer[i]);
		}
		reader.close();
	}

}

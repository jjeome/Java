package com.yedam.java.ch01;

import java.io.FileInputStream;
import java.io.InputStream;

//InputStream
public class ReadExample {

	public static void main(String[] args) throws Exception {
		//읽을 파일 매개변수에 경로 넣기
		InputStream is = new FileInputStream("D:/dev/temp/test1.db");
		//outputstream은 파일이 없어도 문제생기지 않음(파일이 만들어짐)
		//하지만 inputstream은 읽을 파일없으면 문제가 생김
		
		//파일에 있는 모든 값을 읽음
		while(true) {
			//종료 조건
			int data = is.read();//읽어 들인 값을 data에 
			if(data == -1) {
				//-1? 혹시나 리턴값이 read의 끝에 도달해서 -1이 됨
				break;
			}
			System.out.println(data);
		}
		//stream 닫아주기
		is.close();
		
		System.out.println("------------------------");
		//배열 이용하기
		is = new FileInputStream("D:/dev/temp/test2.db");
		//크기를 100으로 하면 한번에 100글자를 읽음
		byte[] buffer = new byte[100];
		//비어있는 byte배열을 넘겨줘야함
		// buffer[0] = 0; //이 값을 덮어씀
		
		//파일의 크기를 모르니 반복문 돌리기
		while(true) {
			//배열을 넘기고 리턴되는 타입을 변수로 넘기기
			//크기가 지정된 byte배열을 넘겨받음
			//1.값을 배열에 집어넣고 2.몇개의 값이 들어온지 리턴함
			int readByteNum = is.read(buffer); //반환하는것이 readByteNum
			if(readByteNum == -1) break;
			for(int i=0; i<readByteNum; i++) { //배열 크기가 2개이니까 2글자를 입력받아 출력한 후 다시 반복해 나머지 출력 
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		is.close();
		
		
		//기존 값에 이어붙여서 쓰려면?
		is = new FileInputStream("D:/dev/temp/test3.db");
		
		int readByteNum = is.read(buffer, 3, 2);//buffer배열의 3부터 2개의 값을 넣기
		
		for(int i = 0; i<(3+readByteNum); i++) {
			System.out.println(buffer[i]);
		}
		
		is.close();
		
		
		//하나씩 출력하기
		System.out.println("\ntest2.db====");
		is = new FileInputStream("D:/dev/temp/test3.db");
		
		while(true) {
			int data = is.read();
			if(data == -1) break;
		System.out.println(data);	
		}
	}
}

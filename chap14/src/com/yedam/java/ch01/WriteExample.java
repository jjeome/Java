package com.yedam.java.ch01;

import java.io.FileOutputStream;
import java.io.OutputStream;

//outputstream을 만들어 데이터를 입력
//outputstream : byte타입
public class WriteExample {

	public static void main(String[] args) throws Exception{
		//파일과 통신(외부) -> 예외가 발생해서 throw해줘야함
		//매개변수에 사용할 파일의 경로 넣어주면 됨 
		OutputStream os = new FileOutputStream("D:/dev/temp/test1.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		//입력stream의 매개변수는 int타입(byte타입이 아님)
		//outputstream으로 그 파일에 쓰고자 하는 값을 매개변수에 넘겨줌
		os.write(a);
		os.write(b);
		os.write(c);
		
		//출력stream
		os.flush(); //한번 끝쪽으로 밀어준 다음에(잔류된 데이터를) 
		os.close(); //stream 닫아줘야함
		
		
		//byte를 배열형식으로 길게 보낼수도 있음
		//위에서 stream close해서 새로 stream 만들어 줘야함
		os = new FileOutputStream("D:/dev/temp/test2.db");
		byte[] arr1 = { 10, 20, 30 };
		//배열 전체를 보냄
		os.write(arr1);
		
		os.flush();
		os.close();
		
		//배열을 통째로 넘기면서 index로 지정한 값만 들고오기
		os = new FileOutputStream("D:/dev/temp/test3.db");
		byte[] arr2 = { 10, 20, 30, 40, 50 };
		os.write(arr2,3,2);//arr2배열에서 3번째 index부터 2개의 값을 출력
		
		os.flush();
		os.close();
	}

}

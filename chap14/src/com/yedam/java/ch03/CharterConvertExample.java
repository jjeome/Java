package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharterConvertExample {

	public static void main(String[] args) throws Exception {
		//기본적으로 파일이 저장되어 있는건 0과 1 : 바이트타입이 대부분.
		//바이트 타입은 하나씩 읽어들여와서 2바트로 만들어서 문자로 만들어야함(보조스트림을 붙여서 데이터) 
		//바이트타입으로 입출력을 만들고, 직접적으로 보이는 데이터로 바꾸기위해 보조스트림(문자로 변환, 기본타입으로 변환) 사용
		System.out.println("입력 문장> ");
		//입력 할 문장에 대한 타입을 지정해주기
		String data = new Scanner(System.in).nextLine();
		write(data);
		//정확하게 읽어오는 지 확인
		read();
		
	}
	
	//파일에 데이터를 집어넣는 입력 스트림(바이트 기반)
	public static void write(String str) throws Exception{
		OutputStream os = new FileOutputStream("D:/dev/temp/test1.txt");
		//os.write(str); -> outpuerstream은 스트림으로 바로 못넘김(바이트기반이라서) ->직접적으로 바꿔줘야함
		//내보낼 때 문자로 내보내고 싶을땐? 보조스트림 사용
		//Writer가 type
		//자기가 start하거나 최종적으로 도달한 곳은 steam임
		//writer:문자기반 스트림이 outputstream과 연결된다는 의미 
		Writer writer = new OutputStreamWriter(os);
	}
	
	//파일을 읽어들이는 출력 스트림
	public static void read() throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/test1.txt");
		//보조스트림으로 대체함 (바이트로 읽어드린 것)
		Reader reader = new InputStreamReader(is); // 직접적으로 데이터를 주고받을 수는 없음
		
		//char타입으로 바꿔주기
		char[ ] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		
		reader.close();
		
		String data = new String(buffer, 0, readCharNum);
		System.out.println(data);
	}

}

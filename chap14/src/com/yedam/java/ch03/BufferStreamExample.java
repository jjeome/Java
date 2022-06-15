package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {

	public static void main(String[] args) throws Exception {
		//buffer스트림이 없는 경우, 복사하고자 하는 주소가 필요함
		//이 클래스에 모든정보(.class까지)를 담고있는class의 class가 생성됨 (위치경로를 찾고(getPath) 그 동일한 패키지 안에 존재하는 파일(getResource)을 찾음)
		String originalFilePath1 = BufferStreamExample.class.getResource("originalFile1.jpg").getPath(); 
		String targetFilePath1 = "D:/dev/temp/targerFile1.jpg";//확장자 동일하게 해야함
		//입력스트림
		InputStream fis1 = new FileInputStream(originalFilePath1);
		//출력스트림
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		//buffer를 사용하지 않았을 때의 시간
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : "+nonBufferTime+"ns");
		fis1.close();
		fos1.close();
		
		//buffer스트림이 있는 경우
		String originalFilePath2 = BufferStreamExample.class.getResource("originalFile2.jpg").getPath(); 
		String targetFilePath2 = "D:/dev/temp/targerFile2.jpg";//확장자 동일하게 해야함
		//입력스트림
		InputStream fis2 = new FileInputStream(originalFilePath2);
		//출력스트림
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		//보조스트림 붙이기
		BufferedInputStream bis = new BufferedInputStream(fis2);//넘겨주고자 하는 stream을 매개변수로 
		BufferedOutputStream bos = new BufferedOutputStream(fos2);//
		//buffer를 사용했을 때의 시간 - 직접 input으로 받아오지않고 buffer로 보조스트림이 넘겨옴
		long bufferTime = copy(bis, bos);
		System.out.println("버퍼를 사용했을 때 \t: "+bufferTime+"ns");
		fis2.close();
		fos2.close();
		
		
	}
	
	//읽어들여와서 바로 복사할 때 얼마만큼의 시간이 걸리는지.
	static int data = -1; //전역 필드
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		long end = System.nanoTime();
		return (end-start);
	}

}

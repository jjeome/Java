package com.yedam.java.ch1101;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {
	public static void main(String[] args) {
		
		Map<Key, String> map = new HashMap<Key, String>(); 
		
		map.put(new Key(1), "홍길동"); //식별 가능함
		//모든 인스턴스를 개별적으로 볼거면 
		
		String value = map.get(new Key(1)); // 필드가 동일하게 들어감 = 1
		System.out.println(value); //value값이 안넘어왔음
	}

}

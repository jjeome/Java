package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int i = map.get("동장군");
		
		map.put("신윤권", 85);
		map.put("홍길동", 95);
		map.put("동장군", 80);
	
		//entry : 두개의 클래스가 하나에 있다는 뜻
		System.out.println("총 Entry 수 : "+map.size());
		
		//return값이 원래 있는지(null인지 아닌지)확인할 때 
		Integer returnVal = map.put("홍길동", 100);
		
		if(returnVal != null) {
			System.out.println("기존 값 : "+returnVal);
		}
		System.out.println("\t 홍길동 : "+map.get("홍길동"));
		System.out.println();	
		
		//중복되지 않게 하기위해서 값을 하나씩 꺼내보는것
		Set<String> keySet = map.keySet();
		//iterator로 순서를 만들어줌(자신의 앞 뒤 연결)
		Iterator<String> keyIterator = keySet.iterator();
		//반복문으로 다음 순서 확인 후 순서가 없을때까지 돌아감)
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		//while문 말고 향상된 for문 써도 상관없음
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		//map에서 값 제거하기 - 식별가능한 key값으로만 제거 가능
		map.remove("홍길동");
		
		//Set컬렉션 key가 아니라 entry 구조로.(중첩 인터페이스)
		//key, value를 하나의 entry로 봄.
		//entry를 담는 set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//순서 정리
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()){
			Map.Entry<String, Integer> entry = entryIterator.next();
			
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		//위 while문과 동일한 향상된 for문
		for(Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println("\t"+key+" : "+value);
		}
	}
	
	

}

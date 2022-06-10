package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		//set에 값 추가하기
		//set : 알아서 중복된것은 튕겨나게 함
		//값을 넣고자 할때 동일한 값이 있는지 확인을 한 후 추가하기
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		//인스턴스로 같은 값을 넣어주려 했지만,오류 -> 비교하는게 다름
		//등호연산자 : 실제메모리 구성을 비교.
		//set, list 인스턴스를 비교할때 hashcode와 equals사용함
		//등호연산자는 다르다고 인식할 수 있지만 (논리적으로는)두개는 같다고 인식
		//####Test class참고해서 보기#####
		set.add(new String("Java"));
		
		System.out.println("총 객체 수 : "+ set.size());
		//Java중복 저장된 것 인식후 제외시킨 총 갯수
		System.out.println();
		
		//반복자 : set class type과 동일하게.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) { //다음에 값이 있는지 확인 - 값이 있으면 다음값으로 넘어감
			String element = iterator.next(); //내부의 값 next메소드로 가지고 오기
			System.out.println("\t"+element); // \t : 탭
		}
		System.out.println();
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		for(String data : set) {
			System.out.println(data);
		}
		
		System.out.println();
		set.clear(); 
		if(set.isEmpty()) {
			System.out.println("비어있음");
		} 
	}

}

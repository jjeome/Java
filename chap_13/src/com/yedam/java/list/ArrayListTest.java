package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		//선언 : 가질 값의 타입을 같이 정의해줘야함
		//ArrayList는 인터페이스이기때문에 자신의 객체를 생성할 수 없음
		List<String> list = new ArrayList<>();
		
		//배열과의 차이 : 최초 선언할 때 크기를 안줌 
		list.add("JAVA");
		list.add("JDBC");
		list.add("Servlet/JSP");
		
		//그냥 값만 적으면 적은 순서대로 나열되지만, index자리를 적어주면 그 자리로 들어감
		//sevlet/jsp를 밀어내고 database가 들어갔음
		list.add(2, "Database");
		list.add("iBATIS");
		
		System.out.println("총 객체 수 : "+list.size());
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2 : "+skill);
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + " : "+list.get(i));
		}
		System.out.println();
		
		//중간에 있는 값 바꿔보기
		list.remove(2); 
		//삭제가 된 후 index가 변경됨 -> 자동으로 index가 변경됨
		list.remove(2);
		list.remove("iBATIS");
		
		System.out.println();
		for(String data : list) {
			System.out.println(data);
		}
	}

}

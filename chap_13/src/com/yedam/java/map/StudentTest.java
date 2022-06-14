package com.yedam.java.map;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		//변수 한개에 new인스턴스를 만들어서 쓰거나 or override하거나
		//변수 쓰는것은 임시방편일 뿐임 override쓰는 것이 좋음
		Student s = new Student(1, "홍길동");
		
		map.put(new Student(1,"홍길동"),95);
		map.put(new Student(1,"홍길동"),100);
		
		System.out.println("총 Entry 수 : "+map.size());
		
		//위와 다른 새로운 인스턴스가 만들어져서 자바는 같다고 인식 못함 -new연산자로 만들어진
		System.out.println("학번  : 1, 이름 : 홍길동, 성적 : "+map.get(new Student(1, "홍길동")));
	}

}

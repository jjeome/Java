package com.yedam.java.map;

public class Student {
	public int sno; //학번
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	//내부의 필드값이 동일한것이 있으면 같은 값으로 만들어주기(자바속이기)
	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}
	
	//내부의 모든 값이 동일한지 확인해주기
	//1.동일한 타입인지 확인 2.강제로 타입을 변환 
	//3.각각의 필드값 확인->true가 나오도록 유도하기
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student) obj;
			return sno == s.sno && s.name.equals(name); 
		} else {
			return false;
		}
	}
}

package com.yedam.java.set;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//개발자가 정의한 class는 별도로 override해서 별도로 정의해줘야함
	
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return name.equals(m.name) && (age == m.age);
		}
		
		return false;
	}
	
	
}

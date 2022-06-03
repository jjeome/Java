package com.yedam.java.ch1101;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		//논리적으로 동등한지
		//1.동일한 타입인지 확인하기(object는 필드가 없음)
		if(obj instanceof Member) {
			//2.내부 필드 값이 같은지 확인하기 (같을경우에는 아래 실행)
			Member member = (Member) obj;
			if(id.equals(member.id)) {//String타입에서는 ==가 아니라 equals를 써줘야함
				return true;
			}
		}
		return false;
		
	}

	@Override
	public int hashCode() {
		return id.hashCode();	
	}

	@Override
	public String toString() {
		return "id : "+id;
	}
	
	

	
	
}

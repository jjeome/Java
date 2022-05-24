package com.yedam.java.ch0605;

public class SingletomTest {

	public static void main(String[] args) {
		//Singleton obj1 = new Singleton(); -> new생성자 오류남
		
		//싱글톤안의 메소드로 접근하면 됨
		Singleton obj1 = Singleton.getinstance();
		Singleton obj2 = Singleton.getinstance();
		
		if(obj1 == obj2) { //동일한 인스턴스 가르킴(주소가 같음)
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
	}

}

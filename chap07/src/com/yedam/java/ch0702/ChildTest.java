package com.yedam.java.ch0702;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();

		GranPa pa = father;//실행은 Granpa 실제는 그 자식들이 호출됨
		pa.method();
		pa = uncle;//인스턴스(자손)가 뭐냐에 따라 값이 달라짐
		pa.method();
		pa = child;
		pa.method();
		pa = cousin;
		pa.method();
	
		/*
		Father fa = uncle;//형제끼리는 타입변환이 일어나지 않음(연관이없음)
		fa = child;//fa에서 파생된 child이기에 가능함
		fa = cousin;
		*/
		System.out.println();
		Father fa = child;
		fa.method();
		
		Child ch = (Child)fa;
		//cousin co = (Cousin)fa;//type변환은관계가 있는 것들 사이에서만 이뤄짐
		
		System.out.println();
		Uncle un = cousin;
		//un = father;
		//un = child;
		un.method();
	}

}

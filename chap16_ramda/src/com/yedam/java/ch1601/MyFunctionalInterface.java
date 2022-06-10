package com.yedam.java.ch1601;

//람다식 문법 사용할 인터페이스
@FunctionalInterface
public interface MyFunctionalInterface {
	//전제조건 : 람다식을 사용하는 인터페이스는 반드시 하나의 메소드만 생성 가능!!
	//         람다식을 사용하는 인터페이스는 람다식이라 미리 정의해줌
	//인터페이스 안에 하나의 메소드만 있도록 미리 정의해줌 : @Functionalinterface	
	//자신을 담아주는 인터페이스안에 여러개의 메소드가 있으면 그중에 어떤곳에 있는지 매칭할 수 없음
	//따라서 람다식에 사용되느 인터페이스는 상수와 메소드를 가지지 않고, 추상메소드 하나만 가질 수 있음
	//람다식을 정의하는 형태로.
	public void method();
}

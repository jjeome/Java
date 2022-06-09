package com.yedam.java.ch1501;

public class Util {
	//제네릭 클래스 타입의 제네릭 메소드
	public static <T> BoxA<T> boxing(T t){
		BoxA<T> box = new BoxA<>();
		box.set(t);
		return box;
	}
	
	//리턴타입이 boolean
	//static뒤의 k,v만이 제네릭. 뒤에 pair에 있는 k,v는 앞의 제네릭을 넣어줘야함.
	//논리적으로 비교할때는 equals. 무조건 equals를 쓰려면 class나 interface가 되어야함
	//보통 class라고 한정.
	//key와 value를 비교.
	public static <K, V> boolean compare(Pair<K,V>p1, Pair<K,V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	
	public static <K, V> V printInfo(K k) {
		V v = null;
		return v;
	}
}

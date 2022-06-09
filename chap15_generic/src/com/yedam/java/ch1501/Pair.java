package com.yedam.java.ch1501;
//제네릭 형태의 클래스
public class Pair<K, V> {
	private K key;
	private V value;
	
	//생성자
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	
}

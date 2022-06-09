package com.yedam.java.ch1501;

public class BoxA<T> {
	private T t;
	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}

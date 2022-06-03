package com.yedam.java.ch1101;

//equelse hasecode toString - object class 
public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key key = (Key)obj;
			if(number == key.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return number; 
	}
	
	@Override //개발자만 인식
	public String toString() {
		return "Key [number=" + number + "]";
	}
	
	
}

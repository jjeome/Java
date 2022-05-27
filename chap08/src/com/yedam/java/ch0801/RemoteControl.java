package com.yedam.java.ch0801;

public interface RemoteControl {
	//상수 필드(필드는 무조건 상수로 봄. 상수라서 무조건 값을 줘야함)
	public static final int MAX_VOLME = 10;
	public int MIN_VOLUME = 0; //일반 필드와는 다름
	
	//추상 메소드
	public abstract void turnOn();
	public void turnOff(); // abstract 없어도 됨. 자바가 알아서 공간 인식해서 처리함
	public void setVolume(int volume);
	
}

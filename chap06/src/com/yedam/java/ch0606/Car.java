package com.yedam.java.ch0606;

public class Car {
	//필드(현재상태에 대한 필드)
	private int speed;
	private boolean stop;//초기화값 false
	
	//생성자
	public int getSpeed() {
		return speed;
	}
	
	//메소드
	public void setSpeed(int speed) {
		if( speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
	
}

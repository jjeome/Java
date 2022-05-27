package com.yedam.java.ch0801;

public class TV implements Control{
	private int volume;
	
	
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume> RemoteControl.MAX_VOLME) {
			this.volume = RemoteControl.MAX_VOLME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this. volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}

	@Override
	public void searchInternet(String url) {
		System.out.println(url+"를 검색합니다.");
	}

	@Override
	public void excuteApp(String app) {
		System.out.println(app+"을 검색합니다.");
	}

	

	
}

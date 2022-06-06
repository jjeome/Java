package com.yedam.java.homework3.game;

public class RPGgame implements Keypad{
	int nowMode;
	
	public RPGgame() {
		nowMode = 0;
		System.out.println("RPGgame 실행");
	}
	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		if(nowMode == 0) {
			System.out.println("캐릭터가 한칸단위로 점프한다.");
		} else if(nowMode == 1){
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}
	}

	@Override
	public void rightDownButton() {
		if(nowMode == 0) {
			System.out.println("캐릭터가 일반 공격.");
		} else if(nowMode == 1){
			System.out.println("캐릭터가 HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		if(nowMode==0) {
			nowMode = 1;
			System.out.println("현재 모드 : HARD_MODE ");
		} else if(nowMode==1) {
			nowMode = 0;
			System.out.println("현재 모드 : NOMAL_MODE");
		}
	}

}
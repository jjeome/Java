package com.yedam.java.homework3.game;

public class ArcadeGame implements Keypad{
int nowMode;
	
	public ArcadeGame() {
		nowMode = 0;
		System.out.println("ArcadeGame 실행");
	}
	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if(nowMode == 0) {
			System.out.println("캐릭터가 일반 공격.");
		} else if(nowMode == 1) {
			System.out.println("캐릭터가 연속 공격.");
		}
	}

	@Override
	public void rightDownButton() {
		if(nowMode == 0) {
			System.out.println("캐릭터가 HIT 공격.");
		} else if(nowMode == 1) {
			System.out.println("캐릭터가 Double HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		if(nowMode == 0) {
			nowMode = 1;
			System.out.println("현재 모드 : HARD_MODE ");
		} else if(nowMode == 1) {
			nowMode = 0;
			System.out.println("현재 모드 : NOMAL_MODE");
		}
	}
}

package com.yedam.java.homework3.game;

public interface Keypad {
	//상수 필드 정의
		public static final int NORMAL_MOD = 0;
		public static final int HARD_MOD = 1;
		
		//추상 메서드 정의
		public abstract void leftUpButton(); //왼쪽에서 위쪽버튼
		public abstract void leftDownButton(); //왼쪽에서 아래쪽 버튼
		public abstract void rightUpButton(); //오른쪽에서 위쪽 버튼
		public abstract void rightDownButton(); //오른쪽에서 아래쪽 버튼
		public abstract void changeMode(); //모드 바꾸고 현재 모드 출력
}

package com.yedam.java.homework3.game;

import java.util.Scanner;

public class ProffesorRandomGame {
	private Keypad game;//필드를 이용해서 값을 고정함
	
	public ProffesorRandomGame() {
		//최초로 게임 셋팅
		setRandomGame();
		
			while(true) {
				//메뉴출력
				menuPrint();
				
				//메뉴입력
				int menuNo = menuSelect();
				
				//기능별 실행
				if(menuNo == 1) {
					game.leftUpButton();
				} else if(menuNo==2) {
					game.leftDownButton();
				} else if(menuNo==3) {
					game.rightUpButton();
				} else if(menuNo==4) {
					game.rightDownButton();
				} else if(menuNo==5) {
					game.changeMode();
				} else if(menuNo==0) {
					setRandomGame();
				} else if(menuNo==9) {
					exit();
					break;
				} else {
					printInputError();
				}
			}
	}
	private void menuPrint() {
		System.out.println("============================================================================================");
		System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println("============================================================================================");
	}
	
	private int menuSelect() {
		System.out.println("choice>> ");
		return new Scanner(System.in).nextInt();
	}
	
	private void exit() {
		System.out.println("EXIT");
	}
	
	private void printInputError() {
		System.out.println("메뉴를 잘못 선택하였습니다.");
	}
	
	private void setRandomGame() {
		int ran = (int)(Math.random()*2);
		switch(ran) {
		case 0:
			game = new RPGgame();
			break;
		case 1:
			game = new ArcadeGame();
			break;
		}
	}
}


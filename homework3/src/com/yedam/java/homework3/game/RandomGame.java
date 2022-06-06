package com.yedam.java.homework3.game;

import java.util.Scanner;

public class RandomGame {
	Scanner scan = new Scanner(System.in);
	RPGgame rpg;
	ArcadeGame arcade;
	int ran = (int) (Math.random()*2); // 0이면 rpm 1이면 arcade
	int count = 0;

	public RandomGame(){
		System.out.println(ran);
		while(true) {
			if(ran == 0) {
				if(count == 0) {
					rpg = new RPGgame();
					count++;
				}
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("============================================================================================");
				int menuNo = inputMenu();
				
				if(menuNo == 1) {
					System.out.println("choice>> 1");
					rpg.leftUpButton();
				} else if(menuNo == 2) {
					System.out.println("choice>> 2");
					rpg.leftDownButton();
				} else if(menuNo==3) {
					System.out.println("choice>> 3");
					rpg.rightUpButton();
				} else if(menuNo==4) {
					System.out.println("choice>> 4");
					rpg.rightDownButton();
				} else if(menuNo==5) {
					System.out.println("choice>> 5");
					rpg.changeMode();
					
				} else if(menuNo == 0) {
					System.out.println("choice>> 0");
					gameChange();
				} else if(menuNo==9) {
					System.out.println("choice>> 9");
					exit();
					break;
				}
				
			} else if(ran == 1) {
				if(count == 0) {
					arcade = new ArcadeGame();
					count++;
				}
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("============================================================================================");
				int menuNo = inputMenu();
				
				if(menuNo == 1) {
					System.out.println("choice>> 1");
					arcade.leftUpButton();
				} else if(menuNo == 2) {
					System.out.println("choice>> 2");
					arcade.leftDownButton();
				} else if(menuNo==3) {
					System.out.println("choice>> 3");
					arcade.rightUpButton();
				} else if(menuNo==4) {
					System.out.println("choice>> 4");
					arcade.rightDownButton();
				} else if(menuNo==5) {
					System.out.println("choice>> 5");
					arcade.changeMode();
				} else if(menuNo == 0) {
					System.out.println("choice>> 0");
					gameChange();
				} else if(menuNo==9) {
					System.out.println("choice>> 9");
					exit();
					break;
				}
				
			}
		}
		
	}
		
	
	private void exit() {
		System.out.println("EXIT");
	}
	
	private static int inputMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	private void gameChange() {
		if(ran == 0) {
			ran = 1;
			System.out.println("현재 게임 : Arcade Game");
			count = 0;
		} else if(ran == 1) {
			ran = 0;
			System.out.println("현재 게임 : RPG Game");
			count = 0;
		}
	}
	

}

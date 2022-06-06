package com.yedam.java.homework3.game;

public class MainProgram{
	RPGgame rpg;
	ArcadeGame arcade;
	
	public MainProgram() {
		rpg = new RPGgame();
		rpg.leftUpButton();
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();
		
		System.out.println("----------------------");
		
		arcade = new ArcadeGame();	
		arcade.leftUpButton();
		arcade.rightUpButton();
		arcade.leftDownButton();
		arcade.changeMode();
		arcade.rightUpButton();
		arcade.leftUpButton();
		arcade.rightDownButton();
	
	}
}

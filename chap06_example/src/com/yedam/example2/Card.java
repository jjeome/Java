package com.yedam.example2;

public class Card {
	//필드
	private static int serialCard = 2000;
	private String name;
	private int cardId;

	//생성자
	public Card() {
		serialCard++;
		this.cardId = serialCard;
		this.name = name;
	}
	
	//메소드
	public static int getSerialCard() {
		return serialCard;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	public void showInfo() {
		System.out.println(name+"님의 카드 번호는 "+cardId+"입니다.");
	}
	*/

}

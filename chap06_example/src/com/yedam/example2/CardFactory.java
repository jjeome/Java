package com.yedam.example2;

public class CardFactory {
	// 싱글톤 만들 때 첫번째,(생성자를 외부에서 x)

	// 필드
	private static CardFactory instance = new CardFactory();

	// 생성자-
	private CardFactory() {}

	
	//메소드
	static CardFactory getInstance() {
		return instance;
}
	public Card createCard() {
		return new Card();
	}

}

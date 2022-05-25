package com.yedam.homework;

public class Question {

		//문제) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
	
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품명과 해당 제품을 제외한 나머지 제품들의 총합(금액)을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
	/*
	//4.분석
	//4-1. 최고가격을 가지고 있는 제품 정보
	public Product getMaxPriceInfo() {
		Product maxInfo = list[0];
		for(int i=1; i <= index; i++) {
			if(maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(Product temp : list) {//list에 있는 값들을 모두 불러옴
			sum+=temp.getPrice();
		}
		int result = sum - maxInfo.getPrice();
		//int result = sum-(getMaxPriceInfo().getPrice());
	 //메소드 이름으로 호출했지만 우리가 만든 product가 실제로 들어옴
		return result;
	}
	
	for(Product temp : list ) {
		if(temp.getPrice() == maxInfo.getPrice()) {
			continue;
			result += temp.getPrice();
		}
	}



*/
}
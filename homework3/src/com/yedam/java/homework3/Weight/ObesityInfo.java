package com.yedam.java.homework3.Weight;

	//비만도
	public class ObesityInfo extends StandardWeightInfo{
		StandardWeightInfo standInfo = new StandardWeightInfo(name, height, weight);
		
		String result;
		double bmi=0;
		
		public ObesityInfo(String name, int height, int weight) {
			super(name, height, weight);
			this.bmi = getObesity();
			this.result = getBmi();
		}
		
		//비만도 구하는 기능
		public double getObesity() {
			standInfo.getStandardWeight();
			return bmi = (weight - weightResult)/weightResult * 100;
		}
		
		//출력
		public String getBmi() {
			getObesity();
			if(bmi<= 18.5) {
				result = "저체중";
			} else if (18.5<bmi && bmi<23.0) {
				result = "정상";
			} else if (23.0 <= bmi && bmi<25.0) {
				result = "과제충";
			} else if (25.0 <= bmi) {
				result = "비만";
			} else {
				result = "BMI 측정 오류";
			}
			return result;
		}
		
		//비만 출력 기능
		@Override
		public void getInformation() {
			System.out.printf("%s님의 신장 %d, 몸무게 %d, %s입니다.", name, height, weight, getBmi());
		}
}

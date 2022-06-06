package com.yedam.java.homework3.Weight;

//표준체중
public class StandardWeightInfo extends Human {
	public double standWeight;
	double weightResult = 0;
	
	
	public StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
		this.standWeight = height;
		this.weightResult = getStandardWeight();
	}
	 
	 //표준체중 구하는 기능
	 public double getStandardWeight() {
		 return (standWeight - 100) * 0.9;
	 }
	 
	 @Override
	 public void getInformation() {
		 System.out.printf("%s님의 신장 %d, 몸무게 %d, 표준체중 %.2f 입니다." , name, height, weight, weightResult);
	 }

}

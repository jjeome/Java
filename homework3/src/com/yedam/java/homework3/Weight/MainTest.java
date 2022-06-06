package com.yedam.java.homework3.Weight;

public class MainTest {

	public static void main(String[] args) {
		Human human = new Human("홍길동", 168, 45);
        StandardWeightInfo standardWeightInfo = new StandardWeightInfo(human.name, human.height, human.weight);
        standardWeightInfo.getInformation();
        System.out.println();

        human.name = "박돌이";
        human.height = 168;
        human.weight = 90;

        ObesityInfo obesityinfo = new ObesityInfo(human.name,human.height, human.weight);
        obesityinfo.getInformation();

	}

}

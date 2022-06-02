package com.yedam.java.ch1001;
//예외처리
import java.util.Scanner;

public class MainText {

	//args : 프로그램을 실행할 때 넘겨받는 배열을 뜻함
	public static void main(String[] args) {
		//실행예외
		//->문법적 문제는 없고 실제 실행 시 발생하는 예외
		//전적으로 개발자의 능력에 맞게 실행
		//정상적으로 실행은 함 (값만 제대로 넘겨준다면) ex.run configurations에 Arguments에서 넘겨줄 값 입력 가능
		
		//NullPointerException : 내가 지금 들고있는 변수가 null값을 들고 있다는 것.
		String data = null; //null값을 가지는건 문제가 아님.
		if(data != null ) {
		System.out.println(data.toString());
		//-아예 위에서 오류가 떠서 밑에애들은 실행 안됨
		}
		
		
		
		//ArrayIndexOutOfBounds:  배열이 가지고 있는 index값중에 벗어난 값을 예상한 것
		if(args.length >= 2) {
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0] : "+data1);
		System.out.println("args[0] : "+data2);
		}
		
		/*
		//NumberFormatException: 숫자형식이 맞지 않을 때 ex.문자->숫자 바꿀때
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
	
		int result = value1 + value2;
		*/
		
		//ClassCastException: Cast-타입변환. 상속관계 혹은 구현관계 안에서 타입변환을 일으켰을 때 발생하는 오류
		changeDog(new Dog());
		changeDog(new Cat());
		
		
		
	}
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) { //오류체크 : instanceof
			Dog dog = (Dog) animal;
		}
	}

}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}










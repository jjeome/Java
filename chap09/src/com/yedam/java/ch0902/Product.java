package com.yedam.java.ch0902;

public class Product {
	//필드
	//인터페이스를 구현해야 하는것이라 반드시 메소드를 오버라이딩 해야함
	RemoteControl field = new RemoteControl() {
		//필드
		String message = "스마트 TV";
		
		//메소드
		void print() {
			System.out.println("제품 종류 : "+message);
		}
		
		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");
		}
		
		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");
		}
	};
	
	//생성자
	
	//메소드 - 로컬변수 익명구현객체
	RemoteControl method1() {
		//method내에서 선언된 또다른 변수의 값을 이용할 때 그 변수는 final성격을 띔
		int volume = 0; //수정해버리면 보장되지 않기 때문에
	
		RemoteControl var = new RemoteControl() {
			//필드
			String message = "Audio";
			//메소드
			void print() {
				System.out.println("제품 종류 : "+message);
			}
			
			@Override
			public void turnOn() {
				print();
				System.out.println("전원을 켭니다.");
				System.out.println("현재 볼륨 : "+volume);
			}
			
			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");
			}
		};
		var.turnOn();
		var.turnOff();
		
		return var;
	}
	
	//매개변수로 선언 후 호출
	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}

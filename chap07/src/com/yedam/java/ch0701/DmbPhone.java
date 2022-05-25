package com.yedam.java.ch0701;

public class DmbPhone extends Phone{ //DmbPhone이 상속받는 자식클래스ㅡ, Phone이 부모클래스
	//object가 아닌 클래스를 부모클래스로 하고싶을때 extends로 지정.
	//Phone은 object의 자식 클래스
	
	//필드
	int ch;
	
	//생성자
	public DmbPhone(String model, String color){
		super(model, color);//명시적으로 만들어 준 것.
		//super();//명시적으로 부모클래스 생성자 호출하지 않아도 java가 알아서 호출메소드 집어넣음
		//왜 new가 없지?-new가 아니기에..? new는 외부에서 호출하려고.
		//super.model = model;//인스턴스에 접근하기위해 this를 씀(new연산자를 생성해 호출해야 인스턴스 만들어짐)
		//super.color = color;//내껀지 부모껀지 구분못하기 때문에 실제로 내꺼면 this. 
		this.ch = 10;//부모꺼를 쓰려면 super를 써야함
	}
	
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 "+ch+"번 방송 수신을 시작합니다.");
	}
	
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	
	void changCh(int ch) {
		this.ch = ch;
		System.out.println("채널 "+ch+"번으로 바꿉니다.");
	}


	@Override
	protected void bell() {
		super.bell();
	}
	
}

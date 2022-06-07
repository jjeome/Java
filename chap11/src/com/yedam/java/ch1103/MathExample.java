package com.yedam.java.ch1103;

public class MathExample {

	public static void main(String[] args) {
		//절댓값 - 숫자만 필요할 때
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = "+v1);
		System.out.println("v2 = "+v2);
		System.out.println();
		
		//올림값 
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 = "+v3);
		System.out.println("v4 = "+v4);
		System.out.println();
		
		//버림값
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5= "+v5);
		System.out.println("v6= "+v6);
		System.out.println();
		
		//최댓값
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v7 = "+v7);
		System.out.println("v8 = "+v8);
		System.out.println();
		
		//최소값
		int v9 = Math.min(5,9);
		double v10 = Math.min(5.3, 2.5);
		System.out.println("v9 = "+v7);
		System.out.println("v10 ="+v10);
		System.out.println();
		
		//랜덤값
		double v11 = Math.random(); //랜덤값만 원할때 random메소드
									//랜덤할 값을 조절할 때는 random클래스
		System.out.println("v11 = "+v11);
		System.out.println();
		
		//가까운 정수의 실수값 - _.5일때 (반값) 좀 애매함
		double v12 = Math.rint(5.3);
		double v13 = Math.rint(5.7);
		System.out.println("v12 = "+v12);
		System.out.println("v13 = "+v13);
		System.out.println();
		
		//반올림값 : rint보다 round쓰는게 더 나음
		//주의 : 소수점 이하 첫번째 자리에서 반올림 함
		//그래서 소수점 이하 두번째 이하부터는 자릿수를 지정해줘야 하기 때문에 *10 *100 이렇게 해줘야함
		long v14 = Math.round(5.3);
		long v15 = Math.round(5.7);
		System.out.println("v14 = "+v14);
		System.out.println("v15 = "+v15);
		System.out.println();
		
		double value = 12.3456;
		double temp1 = value*100;
		long temp2 = Math.round(temp1);
		double v16 = temp2 /100.0;
		System.out.println("v16 = "+v16);
		
	}

}

package com.yedam.java.ch0604_01;
/* 1. 숫자 갯수 입력
 * 2. 그 갯수만큼 숫자 입력
 * 3. 더하기
 * 4. 빼기
 * 5. 곱하기
 * 6. 나누기
 */

public class Calculator {
	//필드
	int[] numList; //숫자입력할 배열선언
	int index; //현재 배열안의 요소 값과 위치를 알기 위한. 
	           //자리가 아님.index는 0부터 길이는 1부터 시작. 단위가 다르니까 맞춰줘야함.
	
	//생성자
	Calculator(){
		index = -1;
	}
	
	//1.갯수입력
	void setArrSize(int size) {
		numList = new int[size];
	}
	
	//2.숫자입력
	void setNum(int num) {
		if((index+1) < numList.length) {
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더 이상 입력할 수 없습니다.");
		}
	}
	
	//값이 2개이상 입력됐는지 확인(조건 체크0)
	boolean ifExecuted(){
		if((index+1)>=2) {
			return true;
		} else {
			System.out.println("숫자를 더 입력해 주세요.");
			return false;
		}
	}
	
	
	//3.더하기
	void plus() {
		int sum = 0;
		if(ifExecuted()) {
			for(int i=0; i<=index; i++) {
				sum += numList[i];
			}
			System.out.println("더한 결과: "+sum);
		}
	}
	
	//4.빼기
	void minus() {
		int min = numList[0]; //0번째는 넘겼으니 1번째부터 누적되려면 int값이 1이 되야함.
		if(ifExecuted()) {
			for(int i=1; i<=index; i++) {
				min -= numList[i];
		
			}
			System.out.println("빼기한 결과: "+min);
		}
	}
	
	//5.곱하기
	 void multi() {
		 int multiple = numList[0];
		 if(ifExecuted()) {
			 for(int i=1; i<=index; i++) {
				 multiple *= numList[i];
			 }
			 System.out.println("곱한 결과: "+multiple);
		 }
	 }
	
	 //나누기
	 void division() {
		 double div = numList[0];
		 if(ifExecuted()) {
			 for(int i=1; i<=index; i++) {
				 div /= (double)numList[i];
			 }
			 System.out.println("나눈 결과: "+div);
		 }
	 }
	 
	
	
}

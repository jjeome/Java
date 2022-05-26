package com.yedam.java.example1;

//고객정보를 저장하는 저장소
public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드 - (customer)등록, 수정, 삭제, 조회
	public void inser(Customer customer) {
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i < listIndex; i++) {
			if (dataList[i].getCustomerID() == customer.getCustomerID())
				;
			dataList[i] = customer;
		}
	}

	// 삭제
	public void delete(int customerId) {
		// 데이터 삭제
		for (int i = 0; i < listIndex; i++) {
			if (dataList[i].getCustomerID() == customerId)
				;
			dataList[i] = null;
		}
	}

	public void cleanDatalist() {
		// 기존 데이터 임시 변수에 복사
		// 데이터 정리
		Customer[] temp = dataList;
		int tempIndex = listIndex;
		// 기존 데이터 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;

		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			}
			dataList[++listIndex] = temp[i];
		}
	}
	
	
	//조회
	public Customer[] selectAll() {
		return dataList;
	}
	
	public Customer selecetOne(int customerId) {
		Customer selected = null;
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerID() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}
	
}


























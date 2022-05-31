package com.yedam.java.proffesor;

import java.util.Scanner;

//program과 db를 연결 : 프로그램안에 전용 저장소를 연결하는 방법 사용
public class BookProgram implements Program {
	private Access dao = BookDAO.getInstance(); //Access의 정보 접근
	private Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void menuPrint() {
		System.out.println("=============================================");
		System.out.println(" 1.정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료 ");
		System.out.println("=============================================");
	}

	
	
	@Override
	public void inputInfo() {
		Book data = inputAll();
		dao.insert(data);
	}

	private Book inputAll() {
		System.out.print("제목> ");
		String title = sc.nextLine();
		//sc.next를 쓰면 단어만 입력 nextLine은 한줄입력인데 ,nextLine을 쓰면 nextInt next는 사용 안됨.
		System.out.print("가격> ");
		int price = Integer.parseInt(sc.nextLine());
		
		return new Book(title,price);
}
	
	
	
	
	@Override
	public void printAllInfo() {
		Book[] list = dao.selectAll();
		//중간에null값이 있다면 향상된 for문은 쓰지 못함
		//for문은 돌아가지만 data.showInfo가 못알아먹음 비어있는 공간에 showInfo를 하니까 안됨
		// list안에 null이 없는 전제조건 하에 향상된 for문 사용가능
		for(Book data : list) {
			data.showInfo();
		}
	}
	
	
	
	

	@Override
	public void printInfo() {
		//isbn 정보 입력
		int keyword = inputOne();
		
		//DAO에서 검색
		Book data = dao.selectOne(keyword);
		
		//출력
		data.showInfo();
	}

	private int inputOne() {
		System.out.println("isbn> ");
		return sc.nextInt();
	}
	
	
	
	
	
	@Override
	public void printRepot() {
		// 가장 비싼 책
		Book maxInfo = selectMaxInfo();
		System.out.println("가장 가격이 비싼 책> ");
		maxInfo.showInfo();
		
		//가장 가격이 낮은 책
		Book minInfo = selectMinInfo();
		System.out.println("가장 가격이 낮은 책");
		minInfo.showInfo();
		
		//두 가지를 제외한 책들의 정보와 평균 가격
		calcAvgInfo();
	}
	
	
	//가장 비싼 책
	private Book selectMaxInfo() {
		//전체조회
		Book[] list = dao.selectAll();
		
		//검색
		Book maxInfo = list[0];
		for(Book data : list) {
			if(maxInfo.getPrice() < data.getPrice()) {
				maxInfo = data;
			}
		}
		//반환
		return maxInfo;
	}
	

	//가장 가격이 낮은 책
	private Book selectMinInfo() {
		Book[] list = dao.selectAll();
		
		Book minInfo = list[0];
		for(Book data : list) {
			if(minInfo.getPrice() > data.getPrice()) {
				minInfo = data;
			}
		}
		return minInfo;
	}
	
	private void calcAvgInfo() {
		//정보 가져오기
		Book maxInfo = selectMaxInfo();
		Book minInfo = selectMinInfo();
		
		Book[] list = dao.selectAll();
		
		int sum = 0;
		for(Book data : list ) {
			if(data.getPrice() > minInfo.getPrice() && data.getPrice() < maxInfo.getPrice()) {
				//조건에 만족하는 경우의 총합
				sum += data.getPrice();
				//조건에 만족하는 경우의 정보를 출력
				data.showInfo();
			}
		}
		double avg = (double)sum/(list.length-2);
		System.out.printf("최고 가격과 최저 가격을 제외한 평균> %.2f\n", avg);
	}
	
}


























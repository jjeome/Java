package com.yedam.java.home;

import java.util.Scanner;

public class BookProgram implements Program{
	private long number = 1L;
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void menuPrint() {
		System.out.println("=============================================");
		System.out.println(" 1.정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료 ");
		System.out.println("=============================================");
	}

	@Override//매개변수를 통해 DB정보 받아오기
	public void inputInfo(BookAccess bookaccess) {
		//사용자가 정보를 입력
		Book info = inputAll();
		bookaccess.insert(info);
	}
	
	
	private Book inputAll() {
		System.out.println("도서 이름> ");
		String bookName = sc.next();
		System.out.println("도서 가격> ");
		int bookPrice = sc.nextInt();
		number++;
		Book returnBook = new Book(bookName, bookPrice, number);
		
		return returnBook;
	}
	
	
	@Override //전체조회
	public void printAllInfo(BookAccess bookaccess) {
		Book[] list = bookaccess.selectAll();
		for(Book book : list) {
			book.showInfo();
		}
	}

	
	private int inputISBN() {
		System.out.println("ISBN 검색> ");
		return sc.nextInt();
	}
	
	@Override //단건조회
	public void printSelectInfo(BookAccess bookaccess) {
		//검색 조건 입력
		int  isbn = inputISBN();
		//저장소에서 검색
		Book info = bookaccess.selectOne(isbn);
		//출력
		info.showInfo();
	}

	@Override
	public void PrintRepo(BookAccess bookaccess) {
		//최고점수
		System.out.println("최고 가격> ");
		int maxInfo = selectMaxPrice(bookaccess);
		System.out.println(maxInfo);
		
		//최저점수
		System.out.println("최저 가격> ");
		int minInfo = selectMinPrice(bookaccess);
		System.out.println(minInfo);
		
		//평균
		System.out.println("최고 가격과 최저 가격을 제외한 평균> ");
		double avg = calAvg(bookaccess);
		System.out.println(avg);
	}
	
	
	int selectMaxPrice(BookAccess bookaccess) {
		Book[] list = bookaccess.selectAll();
		
		Book maxInfo = list[0];
		for(int i=0; i<list.length; i++) {
			if(maxInfo.getBookPrice() < list[i].getBookPrice()) {
				maxInfo = list[i];
			}
		}
		return maxInfo.getBookPrice();
	}
	
	int selectMinPrice(BookAccess bookaccess) {
		Book[] list = bookaccess.selectAll();
		
		Book minInfo = list[0];
		for(int i=0; i<list.length; i++) {
			if(minInfo.getBookPrice() > list[i].getBookPrice()) {
				minInfo = list[i];
			}
		}
		return minInfo.getBookPrice();
	}
	
	private double calAvg(BookAccess bookaccess) {
		Book[] list = bookaccess.selectAll();
		
		int sum = 0;
		double avg = 0;
		for(Book info : list) {
			sum += info.getBookPrice();
		}
		avg = (double)(sum-(selectMinPrice(bookaccess)+selectMaxPrice(bookaccess)))/(list.length-2);
		return avg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.yedam.pro.book;

import java.util.List;
import java.util.Scanner;

public class Management {
	public Scanner sc = new Scanner(System.in);	
	public BooksDAO bDAO = BooksDAO.getInstance();
	public Management () {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//전체조회
				selectAll();
			} else if(menuNo ==2) {
				//단건조회
				selectOne();
			} else if(menuNo ==3) {
				//내용검색
				serchContent();
			} else if(menuNo ==4) {
				//대여가능
				bookRental();
			} else if(menuNo ==5) {
				//책 대여
				bookIn();
			} else if(menuNo ==6) {
				//책 반납
				bookOut();
			} else if(menuNo ==7) {
				//책 등록
				insertBookInfo();
			} else if(menuNo ==9) {
				//종료
				exit();
				break;
			} else {
				//오류문구
				showInfoError();
			}

		}
	}


	private void bookOut() {
		String bookName = inputName();
		bDAO.bookIn(bookName);
	}


	private void bookIn() {
		String bookName = inputName();
		bDAO.bookOut(bookName);
	
	}

	private void bookRental() {
		List<Books> list = bDAO.bookRental();
		for(Books books : list) {
			System.out.println(books);
		}
	}

	private void serchContent() {
		String bookContent = inputContent();
		
		List<Books> list = bDAO.serchContentBooks(bookContent);
		for(Books books : list) {
			System.out.println(books);
		}
	}

	private String inputContent() {
		System.out.println("검색내용 : ");
		return sc.nextLine();
	}

	private void selectOne() {
		String bookName = inputName();
		Books books = bDAO.selectOne(bookName);
		
		
		if(books == null) {
			System.out.println("등록된 책이 아닙니다.");
			return;
		}
		System.out.println(books);
	}

	private String inputName() {
		System.out.println("책 제목 : ");
		return sc.nextLine();
	}

	private void selectAll() {
		List<Books> list = bDAO.selectAll();
		for(Books books : list) {
			System.out.println(books);
		}
	}

	private void insertBookInfo() {
		Books books = inputAll();
		bDAO.insert(books);
	}

	private Books inputAll() {
		Books books = new Books();
		System.out.println("책 제목 : ");
		books.setBookName(sc.nextLine());
		System.out.println("저자명 : ");
		books.setBookWriter(sc.nextLine());
		System.out.println("내용 : ");
		books.setBookContent(sc.nextLine());
		System.out.println("대여여부 : ");
		books.setBookRental(sc.nextInt());
		return books;
	}

	private void showInfoError() {
		System.out.println("메뉴에서 입력해주시기 발바니다.");
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
		}
		return menuNo;
	}

	private void menuPrint() {
		System.out.println("==============================================================================");
		System.out.println(" 1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 | 6.책 반납 | 7.책 등록 | 9.종료 ");
		System.out.println("==============================================================================");
	}
}

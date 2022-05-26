package com.yedam.java.example1;

import java.util.Scanner;
//저장소에서 데이터 가져오기만 하면 됨
public class CustomerSystem {
	// 필드 - DB랑 연결해야함
	private Repo repo = new Repo();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {//코드 묶어서 간편하게 만들어둠
		while (true) {
			// menu 출력, 선택
			menuPrint();
			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 메뉴1 - 회원가입
				signUp();
			} else if (menuNo == 2) {
				// 메뉴2 -회원정보
				myPage();
			} else if (menuNo == 3) {
				// 메뉴3. -결제시 금액
				payInfo();
			} else if (menuNo == 4) {
				// 메뉴4. 종료
				exit();
				break;
			}
		}

	}

	// 메소드
	private void menuPrint() {
		System.out.println("======================================");
		System.out.println("1.회원가입 | 2.회원정보 | 3.결제금액 | 4.종료");
		System.out.println("======================================");
	}

	int menuSelect() {
		System.out.println("메뉴> ");
		return sc.nextInt();
	}                                       

	void myPage() {
		int customerId = inputOne();
		Customer info = repo.selecetOne(customerId);
		info.showInfo();
		System.out.println(info.showInfo());
	}

	void payInfo() {
		int customerId = inputOne();
		Customer info = repo.selecetOne(customerId);

		System.out.println("구매 금액> ");
		int price = sc.nextInt();
		int pay = info.calcPrice(price);
		System.out.println("결제 금액 : " + pay);
	}

	void exit() {
		System.out.println("프로그램 종료");
	}

	int inputOne() {
		System.out.println("고객 아이디> ");
		return sc.nextInt();
	}

	void signUp() {
		// 회원 정보 입력
		Customer info = inputAll();
		// 가입
		repo.inser(info);
	}

	Customer inputAll() {
		//회원 기본 정보 입력
		System.out.println("아이디> ");
		int id = sc.nextInt();
		System.out.println("이름> ");
		String name = sc.next();
		
		//회원 등급 선택
		int selected = selectGrade();
		Customer customer = null;
		switch (selected) {
		case 1:
			customer = new Customer(id, name);
			break;

		case 2:
			customer = new Gold(id, name);
			break;

		case 3:
			customer = new VIP(id, name, "최현정");
			break;
		}
		return customer;
	}

	int selectGrade() {
		System.out.println("=========================");
		System.out.println("1.SILVER | 2.GOLD | 3.VIP");
		System.out.println("=========================");
		return sc.nextInt();
	}

}

package com.yedam.app.members;

import java.util.Scanner;

import com.yedam.app.common.Management;

public class LoginControl {
	private Scanner sc = new Scanner(System.in);
	//로그인 정보 저장
	private static Member LoginInfo = null;
	public static Member getLoginInfo() {
		return LoginInfo;
	}
	
	public LoginControl() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//로그인
				login();
			} else if(menuNo == 2) {
				//종료
				exit();
				break;
			} else {
				//입력오류
				showInputError();
			}
		}
	}

	private void showInputError() {
		System.out.println("메뉴를 확인해주시기 바랍니다.");
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void login() {
		//아이디, 비밀번호 입력받기
		Member inputInfo = inputMember();
		//로그인 시도
		LoginInfo = MembersDAO.getInstance().selectOne(inputInfo);
		//실패할 경우, 메소드 종료
		if(LoginInfo == null) return;
		//성공할 경우, 프로그램을 실행
		System.out.println("로그인 되었습니다.");
		new Management().run();
	}

	private Member inputMember() {
		Member info = new Member();
		System.out.println("아이디>> ");
		info.setMemberId(sc.nextLine());
		System.out.println("비밀번호>> ");
		info.setMemberPassword(sc.nextLine());
		
		return info;
	}

	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menuNo;
	}

	private void menuPrint() {
		System.out.println("================");
		System.out.println(" 1.로그인 | 2.종료 ");
		System.out.println("================");
	}
	
	
}

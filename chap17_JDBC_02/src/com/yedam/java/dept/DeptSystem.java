package com.yedam.java.dept;

import java.util.List;
import java.util.Scanner;

public class DeptSystem {
	
	private DeptDAO dao = DeptDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public DeptSystem() {
		while(true) {
			menuPrint();
			int menuNo = selectMenu();
			if(menuNo == 1) {
				//정보등록
				insertDepartment();
			} else if(menuNo == 2) {
				//정보수정
				updateDepartment();
			} else if(menuNo == 3) {
				//정보삭제
				deleteDepartment();
			} else if(menuNo == 4) {
				//단건조회
				selectDepartment();
			} else if(menuNo == 5) {
				//전체조회
				selectAllDepartment();
			} else if(menuNo == 0) {
				exit();
				break;
			} else {
				inputError();
			}
			
		}
	}

	
	private void selectAllDepartment() {
		List<Departments> list = dao.selectAll();
		for(Departments dept : list) {
			System.out.println(dept);
		}
	}


	private void selectDepartment() {
		//지정한 부서번호 입력 받기
		int departmentId = inputDepartmentId();
		//DB에 검색
		Departments dept = dao.selectOne(departmentId);
		//결과 출력
		if( dept != null ) {
			System.out.println(dept);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}


	private void deleteDepartment() {
		//삭제할 부서번호 입력받기
		int departmentId = inputDepartmentId();
		//DB에 전달
		dao.delete(departmentId);
	}


	private int inputDepartmentId() {
		System.out.println("부서 번호>> ");		
		return Integer.parseInt(sc.nextLine());
	}


	private void updateDepartment() {
		//수정 정보 입력 받기
		Departments dept = inputUpdateInfo();
		//DB에 전달
		dao.update(dept);
	}


	private Departments inputUpdateInfo() {
		Departments dept = new Departments();
		System.out.println("부서 번호>> ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서 이름>> ");
		dept.setDepartmentName(sc.nextLine());
		return dept;
	}


	private void insertDepartment() {
		//정보 입력 받기
		Departments dept = inputAll();
		//DB에 전달
		dao.insert(dept);
	}

	private Departments inputAll() {
		Departments dept = new Departments();
		System.out.println("부서 번호>> ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서 이름>> ");
		dept.setDepartmentName(sc.nextLine());
		System.out.println("상사>> ");
		dept.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서 위치 번호>> ");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));
		
		return dept;
	}


	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void inputError() {
		System.out.println("메뉴에 맞춰 입력해주세요");
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
		}
		return menu;
	}

	private void menuPrint() {
		System.out.println("=====================================================");
		System.out.println(" 1.등록 | 2.수정 | 3.삭제 | 4.단건 조회 | 5.전체 조회 | 0.종료 ");
		System.out.println("=====================================================");
	}
	
}



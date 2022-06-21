package com.yedam.app.products;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management {
	// management의 scanner와 dao 끌어다 쓰면됨
	// 제품에 대한 정보 등록, 수정, 삭제(필요에 따라 DAO 수정할수도 있음)
	// 필드없이 그대로 구현하면 됨

	public ProductInfoManagement() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품 정보 등록
				insertProductInfo();
			} else if (menuNo == 2) {
				// 제품 정보 수정
				updateProductInfo();
			} else if (menuNo == 3) {
				// 제품정보삭제
				deleteProductInfo();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				// 입력오류
				showInputError();
			}
		}
	}

	private void insertProductInfo() {
		// 제품 정보 입력
		Product product = inputAll();
		// DB에 저장
		pDAO.insert(product);
	}

	private void deleteProductInfo() {
		String productName = inputName();

		// 제품 정보 검색
		// -1 products 테이블에서 정보 가져오기
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2 아이디를 이용해 입고 내역이 있는지 확인하기
		boolean isSelected = rDAO.selectInfo(product.getProductId());

		// DB에서 삭제
		if (!isSelected) {
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래내역이 존재합니다.");
		}
	}

	private void updateProductInfo() {
		// 제품이름 입력 받기
		String productName = inputName();
		// 제품 정보 검색
		Product product = pDAO.selectOne(productName);
		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// 수정할 정보 입력 -> 기존의 정보를 넘겨주고 새로운 정보를 반환
		product = inputUpdateInfo(product);

		// DB에 업데이트(수정)
		pDAO.updateInfo(product); //update는 무조건 계속 실행되게 했음 -> 계속 정보가 수정되게
	}

	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름>> ");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격>> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}

	private String inputName() {
		System.out.println("제품이름>> ");
		return sc.nextLine();
	}
	
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존>> " + product.getProductName());
		System.out.println("수정(수정하지 않을경우 0)>> ");
		String name = sc.nextLine();
		if (!name.equals("0")) {
			product.setProductName(name);
		}

		System.out.println("기존 >>" + product.getProductPrice());
		System.out.println("수정 (수정하지 않을 경우 -1 입력)>> ");
		int price = Integer.parseInt(sc.nextLine());
		if (price > -1) {
			product.setProductPrice(price);
		}
		return product;

	}

	@Override
	protected void menuPrint() {
		System.out.println("============================================");
		System.out.println(" 1.제품 등록 | 2.제품 수정 | 3.제품 삭제 | 9.뒤로가기 ");
		System.out.println("============================================");
	}

	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

}

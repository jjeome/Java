package com.yedam.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.history.History;
import com.yedam.app.history.HistoryDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDao = ProductDAO.getInstance();
	private HistoryDAO hDao = HistoryDAO.getInstance();
	public StockManagement() {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo == 1) {
				//제품등록
				inputProduct();
			} else if(menuNo == 2) {
				//제품 입고
				productIn();
			} else if(menuNo == 3) {
				//제품 출고
				productOut();
			} else if(menuNo == 4) {
				//제품 재고
				productStock();
			} else if(menuNo == 5) {
				//제품 조회
				allProductStock();
			} else if(menuNo == 9) {
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}
	

	private void productOut() {
		//출고할 제품과 수량을 입력
		Info info = inputAmount();//값 받아오기
		//등록되어있는 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		if(product == null) {
			System.out.println("해당 제품의 정보를 확인해주세요.");
			return; //실행을 막아버리기
		}
		//재고량이 있는 지 확인
		int stock = selectStock(product.getProductId());
		//재고량과 출고량을 비교(재고량이 출고량보다 적으면 안되기에)
		if(stock >= info.getProductAmount()) {
			//-1 조건을 모두 만족하는 경우 출고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCg(2);
			history.setProductAmt(info.getProductAmount());
			
			hDao.insert(history);
		} else {
			//-2 각 조건이 만족되지 않는 경우 적합한 문구 출력
			System.out.println("재고량이 출고량보다 적습니다.");
		}
		
		
	}
	
	private void productStock() {
		//검색하고자 하는 제품 정보 입력받기
		String productName = inputName();
		//등록된 제품인지 확인
		Product product = pDao.selectOne(productName);
		
		if(product == null) {
			System.out.println("해당 제품의 정보가 등록되어있습니다.");
			return;
		} 
		//맞다면 해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());
		System.out.println("제품 번호 : "+product.getProductId()+", 제품 이름 : "+product.getProductName()+", 재고 : "+stock);
		
	}
	
	

	//기존에 있는 데이터와 이름이 다르게 들어간다는 전제조건 하에.
	private void inputProduct() {
		//제품 정보 입력 받기
		Product product= inputAll();
		//DB에 저장
		pDao.insert(product);
	}
	
	private void productIn() {
		//입고할 제품과 수량 입력
		Info info = inputAmount();
		//기존에 등록되어 있던 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		
		if(product != null) {
			//-1 기존에 등록된 제품일 경우 입고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCg(1);
			history.setProductAmt(info.getProductAmount());
			
			hDao.insert(history);
			
		} else {
			//-2 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품의 정보를 우선 등록해주세요.");
		}
		
	}
	
	
	private void allProductStock() {
		Map<Integer, Integer> list = hDao.selectAllAmount();
		Set<Integer> productList = list.keySet();
		for(int productId : productList) {
			Product product = pDao.selectOne(productId); //id로 정보를가져와야함
			int stock = list.get(productId);
			
			System.out.println("제품 번호 : "+product.getProductId()+", 제품 이름 : "+product.getProductName()+", 재고 : "+stock);
			
		}
		
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품 이름>> ");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격>> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}
	
	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품 이름>> " );
		info.setProductName(sc.nextLine());
		System.out.println("제품 수량>> ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		
		return info;
	}
	
	private String inputName() {
		System.out.println("제품 이름>>");
		return sc.nextLine();
	}
	
	private int selectStock(int productId) {
		int in = hDao.selectInAmount(productId);
		int out = hDao.selectOutAmount(productId);
		return (in-out);
	}


	private void showInputError() {
		System.out.println("메뉴에 맞춰 입력해주세요.");
	}


	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}


	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menu;
	}


	private void menuPrint() {
		System.out.println("==========================================================");
		System.out.println(" 1.제품등록 | 2.제품입고 | 3.제품출고 | 4.제품재고 | 5.전체재고 | 9.종료 ");
		System.out.println("==========================================================");
	}
}

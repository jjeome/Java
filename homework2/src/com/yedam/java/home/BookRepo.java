package com.yedam.java.home;

public class BookRepo implements BookAccess{
	private static BookRepo instance = new BookRepo();
	private BookRepo() {
		init();
	
	}
	
	private void init() {
		dataList = new Book[100];
		listIndex = -1;
	}

	public static BookRepo getInstance() {
		return instance;
	}
	
	//실제 사용 필드 및 메소드
	private Book[] dataList;
	private int listIndex;
	
	//등록
	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;	
	}

	//전체조회
	@Override
	public Book[] selectAll() {
		Book[] list = new Book[listIndex+1];
		for(int i=0; i< list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	//단건조회
	@Override
	public Book selectOne(int ISBN) {
		Book selected = null;
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getISBN() == ISBN) {
				selected = dataList[i];
			}
		}
		return selected;
	}

	//삭제
	private void cleanDataList() {
		//기존 데이터 -> 임시변수
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		//기존 필드 초기화
		init();
		//임시변수에서 데이터만 기존 필드로 복사
		for(int i=0; i<=tempIndex; i++) {
			if( tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
		
	}
	
	@Override
	public void delete(String bookName) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getBookName() == bookName) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}
	
	
	

}

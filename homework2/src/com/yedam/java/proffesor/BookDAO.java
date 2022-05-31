package com.yedam.java.proffesor;

public class BookDAO implements Access {
	//싱글톤 : 하나의 인스턴스로만 접속하는게 좋음 (일관성유지때문에) - 생성자를 private으로 만드는 것
	private static BookDAO instance = new BookDAO();
	private BookDAO() {
		init();
	}

	public static BookDAO getInstance() {
		return instance;
		
	}
	
	//실제로 사용할 필드 및 메소드
	private Book[] dataList;
	private int listIndex;
	private void init() {
		dataList = new Book[100];
		listIndex = -1;
	}
	
	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;
	}

	@Override
	public void update(Book book) {
		for(int i=0; i<= listIndex; i++) {
			if(dataList[i].getIsbn() == book.getIsbn()) {
				dataList[i] = book; // 기존에 있는 데이터를 바꿔넣는것.
			}
		}
	}

	@Override
	public void delete(int isbn) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getIsbn() == isbn) {
				dataList[i] = null;//중간중간에 null값이 들어가면 배열 중간이 비워짐->정리를 해줘야함(비어있는공간을 밀어서 채우기)
			}
		}
		cleanDataList();
	}
	
	
	private void cleanDataList() {
		//기존 필드 -> 임시변수로 값 복사 (listIndex와 dataList를 복사하기)
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		
		//기존 필드 초기화
		init();
		
		//임시변수 -> 기존필드로 값을 옮김
		for(int i=0; i<=tempIndex; i++) {
			if(tempList[i] != null) {
				dataList[++listIndex] = tempList[i]; //새로 인덱스 번호를 넣어서 배열에 넣어주기
				//dataList의 i와 tempList의 i는 다름
			}
		}
	}
	
	@Override 
	// 꽉찬 데이터로 0부터 listIndex가 이루어져 있음
	public Book[] selectAll() {
		Book[] list = new Book[listIndex+1];
		
		for(int i=0; i<=listIndex; i++) {
			list[i] = dataList[i];//둘의 값이 같아도 됨
		}
		return list;
	}

	@Override
	public Book selectOne(int isbn) {
		Book book = null;
		
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getIsbn() == isbn) {
				book = dataList[i];
				break; 
			}
		}
		return book;
	}

}

package com.yedam.java.example2;

public class StudentRepo implements Access {
	//프로젝트는 저장소 1개 - 싱글톤으로 만들어야함.
	//싱글톤 생성자는 무조건 private 
	//내부에서 인스턴스 만들고 접근할수있게 함(static)필수
	//private으로 막은 이유는? -> 필드에 접근에 데이터 바꿀 수 있기 때문
	//private / static / 본인 자신에 대한 인스턴스 -> 순서 꼭 외우기!
	private static StudentRepo instance = new StudentRepo();
	private StudentRepo() {
		init();//메소드 초기화할때
	}
	
	//반환할 수 있도록 클래스 정보에 접근하려면 클래스명으로 접근해야함
	public static StudentRepo getInstace() {
		return instance;
	}
	
	//실제 사용 필드 및 메소드
	private Student[] dataList;
	private int listIndex;
	//초기화
	private void init() {
		dataList = new Student[100];
		listIndex =-1;
	}
	
	@Override
	public void inser(Student student) {
		dataList[++listIndex] = student;
	}

	@Override
	public void update(Student student) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId() == student.getId()) {
				dataList[i] = student;
			}
		}
	}

	@Override
	public void delete(int studentId) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}
	
	private void cleanDataList() {
		//기존 데잍 -> 임시변수
		Student[] tempList = dataList;
		int tempIndex = listIndex;
		//기존 필드 초기화
		init();
		//임시변수에서 데이터만 기존 필드로 복사
		for(int i=0; i<=tempIndex; i++) {
			if(tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
	}

	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex+1];//listIndex는 인덱스를 가지는 크기
		for(int i=0; i< list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Student selectOne(int studentId) {
		Student selected = null;
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				selected = dataList[i];
			}
		}
		return selected;
	}

}

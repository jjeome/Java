package co.edu.vo;

public class Page {
	private int startPage; // 보여지는 페이지에서 첫번째 페이지 150페이지 안에(11~20)
	private int endPage; // 보여지는 페이지에서 마지막 페이지 
	private boolean prev; // 이전페이지가 있는지
	private boolean next; // 다음페이지가 있는지
	
	
	private int total; //데이터 전체 건수
	private Criteria cri; 
	
	public Page(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//ceil : 반올림
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)*10); //현재 17페이지면? 시작:11 종료:20 페이지
		this.startPage = this.endPage - 9;
		//cri.getAmount : 실제 데이터를 가져온 값으로 전체페이지를 나눠줌
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
		
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

}

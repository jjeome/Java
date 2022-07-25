package com.tst.board;


//VO(Value Object) : 글제목, 글내용, 작성자, 작성일자, 방문횟수.
public class BoardVO {
	
	private int boardId;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int count;
	
	public BoardVO() {}
	
	public BoardVO(int boardId, String title, String content, String writer, String createDate, int count) {
		super();
		
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createDate = createDate;
		this.count = count;
	}
	
	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}

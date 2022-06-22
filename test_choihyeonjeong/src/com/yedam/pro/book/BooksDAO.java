package com.yedam.pro.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yedam.book.common.DAO;

public class BooksDAO extends DAO {
	//싱글톤
	private static BooksDAO booksDAO = null;
	private BooksDAO () {}
	public static BooksDAO getInstance() {
		if(booksDAO == null) {
			booksDAO = new BooksDAO();
		}
		return booksDAO;
	}
	
	//등록
	public void insert(Books books) {
		try {
			connect();
			String sql = "INSERT INTO books (book_name, book_writer, book_content, book_rental) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, books.getBookName());
			pstmt.setString(2, books.getBookWriter());
			pstmt.setString(3, books.getBookContent());
			pstmt.setInt(4, books.getBookRental());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 책이 등록되었습니다.");
			} else {
				System.out.println("정상적으로 책이 등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void bookOut(String bookName) {
		try {
			connect();
			String sql = "UPDATE books SET book_rental = 1 WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName); 
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("책이 대여되었습니다.");
			} else {
				System.out.println("책이 대여되지 않았습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	

	public void bookIn(String bookName) {
		try {
			connect();
			String sql = "UPDATE books SET book_rental = 0 WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName); 
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("책이 반납되었습니다.");
			} else {
				System.out.println("책이 반납되지 않았습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//단건조회 
	public Books selectOne(String bookName) {
		Books books = null;
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				books = new Books();
				books.setBookName(rs.getString("book_name"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setBookContent(rs.getString("book_content"));
				books.setBookRental(rs.getInt("book_rental"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return books;
	}
	
	//단건조회 - 내용검색
	public List<Books> serchContentBooks(String bookContent) {
		List<Books> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_content LIKE '%"+bookContent+"%'";
			
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Books books = new Books();
				books.setBookName(rs.getString("book_name"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setBookContent(rs.getString("book_content"));
				books.setBookRental(rs.getInt("book_rental"));
				
				list.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//전체조회
	public List<Books> selectAll(){
		List<Books> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM books ORDER BY book_name";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Books books = new Books();
				books.setBookName(rs.getString("book_name"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setBookContent(rs.getString("book_content"));
				books.setBookRental(rs.getInt("book_rental"));
				
				list.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//책 대여 가능 조회
	public List<Books> bookRental(){
		List<Books> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_rental = 0";
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Books books = new Books();
				books.setBookName(rs.getString("book_name"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setBookContent(rs.getString("book_content"));
				books.setBookRental(rs.getInt("book_rental"));
				
				list.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	
	
}

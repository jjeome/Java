package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yedam.app.common.DAO;


//sql문 db에서 쿼리문 실행되는지 확인하고 자바에 들고오기
public class ProductsDAO extends DAO{
	//등록 -> 매개변수로 vo 객체 넘어옴(일부 값만 한다 하더라도 vo객체) 
	public void insert(Product product) {
		try {
			connect();
			
			//공백 잘 넣기 주의!
			String sql = "INSERT INTO products (product_id, product_name, product_price) "
						+"VALUES (products_seq.nextval, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
	}
	
	//수정 - 재고
	public void update(Product product) {
		try {
			connect();
			//바로 메소드를 넣어줘도됨 -> 이 상태에서 preparedStatement써도 상관은 없음
			String sql = "UPDATE products SET product_stock = "+ product.getProductStock() 
						 +"WEHRE product_id ="+product.getProductId();
			
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
	}
	
	//삭제 -> 매개변수에 vo클래스 다 넣지말고 보통 DB 테이블의 기본키로 삭제함
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM products WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
	}
	
	//단건조회 - 재고이름
	//단독으로조회이기 때문에 리턴타입이 클래스 단독으로 옴
	//조건이 한개면 매개변수 지정해서 넣어주기. 조건이 여러개면 vo클래스 넣어주면 됨
	public Product selectOne(String productName) {
		Product product = null; //항상 리턴되는 타입의 변수에 null값 주기 -> 변수값 채운다는 식으로 
		
		try {
			connect();
			//primary key가 아니면 중복되는 값을 가지고 올 수 있기 때문에, 주의를 줘야함(자바에서 찾기 어려움) -> 무조건 developer에서 확인해보기
			String sql = "SELECT * FROM products WHERE product_name = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs = pstmt.executeQuery();
			
			//while문 써도 1개의 값만 가져올 수 있음 -> 덮어쓰기 때문에(list로 담는 것이 아니기때문에)
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}

		return product;
	}
	
	
	//전체조회 - 리턴되는 값이 list
	public List<Product> seleceAll(){
		List<Product> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY product_id"; //전체조회는 정렬해주는게 좋음
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//데이터의 갯수를 모르니까 while문 돌리기
			while(rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductStock(rs.getInt("product_stock"));
				
				list.add(pro);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		
		return list;
	}







}

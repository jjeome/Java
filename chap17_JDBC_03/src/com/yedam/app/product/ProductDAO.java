package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO{
	//싱글톤
	private static ProductDAO productDAO = null;
	private ProductDAO(){}
	public static ProductDAO getInstance() {
		if(productDAO == null){
			productDAO = new ProductDAO();
		}
		return productDAO;
	}
	
	//CRUD
	//등록
	public void insert(Product product) {
		try {
			connect();
			//시퀀스로 되어있기 때문에 ? 전에 시퀀스 값 넣어줘야함 (시퀀스와 연결해줘야함)
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,product.getProductName());
			pstmt.setInt(2,product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//수정 ->무엇을 수정? -가격
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price = ? WHERE product_id = ?";
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id ="+productId;
			pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
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
	
	//전체조회
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<Product>();
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				list.add(pro);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회 ->무엇을 조회? 1.제품번호 
	public Product selectOne(int productId){
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_id = "+productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pro;
	}
	
	//단건조회 ->무엇을 조회? 2.제품이름
	public Product selectOne(String productName){
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_name = "+productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pro;
	}
}

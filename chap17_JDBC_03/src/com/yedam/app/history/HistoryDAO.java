package com.yedam.app.history;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO{
	//싱글톤
	private static HistoryDAO historyDAO = null;
	private HistoryDAO() {}
	//getinstance는 외부에서 호출받아야하기 때문에 public
	public static HistoryDAO getInstance() {
		if(historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		
		return historyDAO;
	}
	
	//CRUD(해당테이블에서만 일어나는)
	//1.등록
	public void insert(History history) {
		try {
		connect();
		String sql = "INSERT INTO product_history VALUES(?,?,?)";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,history.getProductId());
			pstmt.setInt(2, history.getProductCg());
			pstmt.setInt(3, history.getProductAmt());
			
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
	//2.수정 - 수량
	public void update(History history) {
		try {
			connect();
			String sql = "UPDATE product_historoy SET product_amount = ? WHERE product_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,history.getProductAmt());
			pstmt.setInt(2,history.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 수정이 완료되었습니다.");
			} else {
				System.out.println("정상적으로 수정이 완료되지 않았습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//3.삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE produt_id ="+ productId;
			pstmt = conn.prepareStatement(sql);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 삭제가 완료되었습니다.");
			} else {
				System.out.println("정상적으로 삭제가 완료되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//4.단건조회
	//1. 각 상품에 대한 입고량
	public int selectInAmount(int productId) {
		int result = 0;
		
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				//as를 사용해 별칭을 가져올 수 있음 ex.as sum -> 여기서 "sum"만 하면 됨
				result = rs.getInt("SUM(product_amount)");
				//result = rs.getInt(1);
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	//2. 단건 조회 - 각 상품에 대한 출고량
	public int selectOutAmount(int productId) {
		int result = 0;
		
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id = ? AND product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				//as를 사용해 별칭을 가져올 수 있음 ex.위의 쿼리문에 as sum -> 여기서 "sum"만 하면 됨
				result = rs.getInt("SUM(product_amount)");
				//result = rs.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}
	//5.전체조회 - 전체 상품의 각 재고
	public Map<Integer, Integer> selectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			//각 제품에 따른 입고량과 출고량 들고오기
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs =stmt.executeQuery(sql);
			
			//입고와 출고에 따른 각각의 목록만들기
			//섞여있으니까 해당열의 카테고리를 나워서 in과 out에 나눠서 담을것. -> 한테이블안에 있어서 연산하기 어려우기에 나눠서 담기
			//why map사용? : 제품이름이 딱 정해져 있어서 map으로 다루기 쉬움
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			
			while(rs.next()) {
				int category = rs.getInt("product_category"); 
				//입고량
				if(category == 1) {
					inList.put(rs.getInt("product_id"),rs.getInt("amount"));
				} 	//출고량
					else {
					outList.put(rs.getInt("product_id"),rs.getInt("amount"));
				}
			}
			
			//한바퀴 돌면서 재고 구하기(입고가 있다는 기반으로 출고가 있음)
			Set<Integer> keySet = inList.keySet();
			for(int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				//재고수량이 있을때만 출고
				if(outAmount != null) {
					list.put(key, (inAmount-outAmount)); //이 자체가 출고
				} else {
					list.put(key, inAmount);
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

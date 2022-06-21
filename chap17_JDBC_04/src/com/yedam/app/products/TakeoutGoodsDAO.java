package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.deal.DealInfo;

public class TakeoutGoodsDAO extends DAO {
	//싱글톤
	private static TakeoutGoodsDAO dao = null;
	private TakeoutGoodsDAO() {}
	private static TakeoutGoodsDAO getInstance() {
		if(dao == null) {
			dao = new TakeoutGoodsDAO();
		}
		return dao;
	}
	
	//등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO take_out_goods (product_id, product_amount) VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
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
	
	//단건조회 - 출고내역 존재유무
	public void selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connect();
			String sql = "SELECT COUNT(*) AS count FROM take_out_goods WHERE product_id ="+productId;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.getInt("count")>0) {
				isSelected = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//단건조회-출고 수량
	public void selectAmount(int proudctId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as sum FROM take_out_goods WHERE product_id="+proudctId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				amount = rs.getInt("sum");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//전체조회-현재까지 출고된 내역
	public List<DealInfo> selectAll(){
		List<DealInfo> list = new ArrayList();
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM take_out_goods ";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//전체조회-해당 날짜에 출고된 내역
	
	//전체조회-해당 제품의 출고된 내역
	
}

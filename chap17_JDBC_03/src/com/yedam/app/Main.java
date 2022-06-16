package com.yedam.app;

import java.util.List;

import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class Main {

	public static void main(String[] args) {
		List<Product> list = ProductDAO.getInstance().selectAll();
		for(Product pro : list) {
			System.out.println(pro);
		}
	}

}

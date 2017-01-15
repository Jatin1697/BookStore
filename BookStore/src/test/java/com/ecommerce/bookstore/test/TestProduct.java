package com.ecommerce.bookstore.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.bookstore.DAOImpl.ProductDaoImpl;
import com.ecommerce.bookstore.model.Product;

public class TestProduct {
	
	@Autowired
	Product pro;
	
	@Autowired
	ProductDaoImpl PDI;
	
	@Test
	public void testMethod(){
		
		pro.setProduct_id(1);
		pro.setDescription("Love Story of people from two different religions");
		pro.setPrice(249);
		pro.setProduct_name("2 States");
		pro.setQuantity(5);
		
		
	}
}

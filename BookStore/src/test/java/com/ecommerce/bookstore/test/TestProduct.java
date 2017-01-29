package com.ecommerce.bookstore.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.SupplierDao;
import com.ecommerce.bookstore.model.Category;
import com.ecommerce.bookstore.model.Product;
import com.ecommerce.bookstore.model.Supplier;

public class TestProduct {
	
	@Autowired
	Product pro;
	
	@Autowired
	ProductDao PDI;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce.bookstore");
		context.refresh();
		
		pro = (Product) context.getBean("product");
		PDI = (ProductDao) context.getBean("productDao");
		
		category = (Category) context.getBean("category");
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDao = (SupplierDao) context.getBean("supplierDao");
				
		System.out.println("got bean");
	}
	
	@Test
	public void testMethod(){
		
		pro.setProduct_id(1);
		pro.setDescription("Love Story of people from two different religions");
		pro.setPrice(249);
		pro.setProduct_name("2 States");
		pro.setQuantity(5);
		pro.setAuthor("Chetan Bhagat");
		pro.setCategory(categoryDao.getCategory(1));
		
		PDI.addProduct(pro);
		List<Product> products = PDI.getAllProducts();
				
		assertEquals(1,products.size());
		System.out.println("Add Product Method Checked");
		
		pro.setPrice(288);
		PDI.updateProduct(pro);
		Product product =  (Product)PDI.getProduct(pro.getProduct_id());
		assertEquals(288, product.getPrice());
		
		System.out.println("Update Product Mehtod Checked");
		
		PDI.deleteProduct(pro);
		List<Product> products1 = PDI.getAllProducts();
		
		assertEquals(0,products1.size());
		System.out.println("Delete Product Method Checked");
	}
	
}

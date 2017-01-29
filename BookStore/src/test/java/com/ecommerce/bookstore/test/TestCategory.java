package com.ecommerce.bookstore.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.model.Category;

public class TestCategory {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecommerce.bookstore");
		context.refresh();
		
		category = (Category) context.getBean("category");
		categoryDao = (CategoryDao) context.getBean("categoryDao");
				
		System.out.println("got bean");
	}
	
	@Test
	public void testMethod() {
		
		category.setCategory_id(2);
		category.setCategory_name("Fiction");
		
		categoryDao.addCategory(category);
		List<Category> cat = categoryDao.getAllCategory();
		
		assertEquals(2,cat.size());
		System.out.println("Add Category Method Checked");
		
		category.setCategory_name("Text");
		categoryDao.updateCategory(category);
		Category category2 = (Category) categoryDao.getCategory(1);
		assertEquals("Text", category2.getCategory_name());
		
		System.out.println("Update category Mehtod Checked");
		
		categoryDao.deleteCategory(category2);
		List<Category> category1 = categoryDao.getAllCategory();
		
		assertEquals(1,category1.size());
		System.out.println("Delete category Method Checked");
	}

}

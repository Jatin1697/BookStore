/*package com.ecommerce.bookstore.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;

public class TestUsers {

		@Autowired
		Users u;
		
		@Autowired
		UserDao UDI;
		
		AnnotationConfigApplicationContext context;
		
		@Before
		public void init() {
			
			context = new AnnotationConfigApplicationContext();
			context.scan("com.ecommerce.bookstore");
			context.refresh();
			
			u = (Users) context.getBean("users");
			UDI = (UserDao) context.getBean("userDao");
			System.out.print("Got Bean");
		}
		
		@Test
		public void testUsersMethod() {
			
			u.setUsername("Rahul");
			u.setEmail("rahul@gmail.com");
			u.setMobile("1234567899");
			u.setAddress("Bangalore");
			u.setPassword("122345");
		}
}*/

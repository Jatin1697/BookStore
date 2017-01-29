package com.ecommerce.bookstore.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.bookstore.DAO.SupplierDao;
import com.ecommerce.bookstore.model.Supplier;

public class TestSuppliers {

		@Autowired
		Supplier supplier;
		
		@Autowired
		SupplierDao SDI;
		
		AnnotationConfigApplicationContext context;
		
		@Before
		public void init() {
			
			context = new AnnotationConfigApplicationContext();
			context.scan("com.ecommerce.bookstore");
			context.refresh();
			
			supplier = (Supplier) context.getBean("supplier");
			SDI = (SupplierDao) context.getBean("supplierDao");
			System.out.print("Got Bean\n");
		}
		
		@Test
		public void testMethod() {
			
			supplier.setSupplier_id(1);
			supplier.setSupplier_name("Pearson Publication");
			supplier.setSupplier_email("pearson@gmail.com");
			supplier.setSupplier_mob_no("8877665544");
			supplier.setSupplier_address("Delhi");
			
			SDI.addSupplier(supplier);
			Supplier s = SDI.getSupplier(1);
			assertEquals("Pearson Publication", s.getSupplier_name());
			System.out.println("Add Supplier Method Checked");
			
			List<Supplier> sup = SDI.getAllSuppliers();
			assertEquals(1,sup.size());
			System.out.println("List Of Suppliers Checked");
			
			supplier.setSupplier_mob_no("9988776655");
			SDI.updateSupplier(supplier);
			Supplier s1 = SDI.getSupplier(1);
			assertEquals("9988776655", s1.getSupplier_mob_no());
			System.out.println("Update Supplier Method Checked");
			
			SDI.deleteSupplier(supplier);
			List<Supplier> supp = SDI.getAllSuppliers();
			assertEquals(0,supp.size());
			System.out.println("Delete Supplier Method Checked");
		}
}

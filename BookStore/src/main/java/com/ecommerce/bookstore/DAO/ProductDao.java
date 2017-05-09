package com.ecommerce.bookstore.DAO;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ecommerce.bookstore.model.Product;


public interface ProductDao {

		@PreAuthorize("hasRole('ROLE_USER')")
		public void addProduct(Product p);
		public void updateProduct(Product p);
		public boolean deleteProduct(Product p);
		public List<Product> getAllProducts();
		public Product getProduct(int product_id);
		public List<Product> getProductByCategory(int categoryId);
		public Product getProductByName(String product_name);
		public List<String> getProductListByName(String product_name);
		
}

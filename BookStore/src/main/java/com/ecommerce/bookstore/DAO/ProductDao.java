package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Product;


public interface ProductDao {

		public void addProduct(Product p);
		public void updateProduct(Product p);
		public boolean deleteProduct(Product p);
		public List<Product> getAllProducts();
		public Product getProduct(int product_id);
		public List<Product> getProductByCategory(int categoryId);
		
}

package com.ecommerce.bookstore.DAO;

import com.ecommerce.bookstore.model.Product;

public interface ProductDao {

		public void addProduct(Product p);
		public void updateProduct(Product p);
		public boolean deleteProduct(Product p);
		
}

package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> getAllCategory();
	public Category getCategory(int category_id);
	public Category getCategoryByName(String category_name);
}

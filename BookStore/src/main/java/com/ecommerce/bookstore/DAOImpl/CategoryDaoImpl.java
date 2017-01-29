package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.model.Category;

@Transactional
@Repository(value = "categoryDao")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(category);
	}

	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(category);
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>)sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategory(int category_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, category_id);
	}
	

}

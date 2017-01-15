package com.ecommerce.bookstore.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.model.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(p);
	}

	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(p);
	}

	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}

	
}

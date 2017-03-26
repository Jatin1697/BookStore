package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.model.Product;

@Transactional
@Repository(value="productDao")
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
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class,product_id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product  where category_id  ="+ categoryId).list();
	}

	@Override
	public Product getProductByName(String product_name) {
		// TODO Auto-generated method stub
		Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("product_name", product_name));
		return (Product)criteria.uniqueResult();
	}

	
}

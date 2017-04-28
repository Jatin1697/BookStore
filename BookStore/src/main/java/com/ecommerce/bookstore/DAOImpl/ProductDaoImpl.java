package com.ecommerce.bookstore.DAOImpl;

import java.util.ArrayList;
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

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(p);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		return (List<Product>) criteria.list();
	}

	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("product_id", product_id));
		return (Product)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("category_id", categoryId));
		return (List<Product>)criteria.list();
	}

	@Override
	public Product getProductByName(String product_name) {
		// TODO Auto-generated method stub
		Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("product_name", product_name));
		return (Product)criteria.uniqueResult();
	}

	@Override
	public List<String> getProductListByName(String product_name) {
		// TODO Auto-generated method stub
		Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("product_name", product_name + "%"));
		@SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>)criteria.list();
		List<String> list = new ArrayList<>();
		
		for(Product product : productList)
		{
			list.add(product.getProduct_name());
		}
		
		return list ;
	}

	
}

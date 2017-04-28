package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.CartDao;
import com.ecommerce.bookstore.model.Cart;

@Repository(value = "cartDao")
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(cart);
	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(cart);
	}

	public boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(cart);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Cart> getCartItems(String username) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
		criteria.add(Restrictions.like("username", username));
		return (List<Cart>) criteria.list();
	}

	public Cart getCart(int cart_id) {
		// TODO Auto-generated method stub
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, cart_id);
	}

}

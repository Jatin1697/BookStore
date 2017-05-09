package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.CartDao;
import com.ecommerce.bookstore.model.Cart;

@Transactional
@Repository(value = "cartDao")
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
	public List<Cart> getCartItems(int user_id) {
		// TODO Auto-generated method stub
		return (List<Cart>) sessionFactory.getCurrentSession().createQuery("from Cart where user_id = " + user_id).list();
	}

	public Cart getCart(int cart_id) {
		// TODO Auto-generated method stub
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, cart_id);
	}

}

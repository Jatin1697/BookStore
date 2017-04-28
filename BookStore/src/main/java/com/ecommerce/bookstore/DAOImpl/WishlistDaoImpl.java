package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.WishlistDao;
import com.ecommerce.bookstore.model.Wishlist;


@Transactional
@Repository(value="wishlistDao")
public class WishlistDaoImpl implements WishlistDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(wishlist);
	}

	@Override
	public void updateWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(wishlist);
	}

	@Override
	public boolean deleteWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(wishlist);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wishlist> getWishlistItems(String username) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Wishlist.class);
		criteria.add(Restrictions.like("username", username));
		return (List<Wishlist>) criteria.list();
	}

	@Override
	public Wishlist getWishlist(int wishlist_id) {
		// TODO Auto-generated method stub
		return (Wishlist) sessionFactory.getCurrentSession().get(Wishlist.class, wishlist_id);
	}

}

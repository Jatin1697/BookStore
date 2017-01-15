package com.ecommerce.bookstore.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void addUser(Users u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(u);
	}

}

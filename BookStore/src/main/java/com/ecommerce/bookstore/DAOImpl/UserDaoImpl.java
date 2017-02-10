package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

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

	public void updateUser(Users u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(u);
	}

	public boolean deleteUser(Users u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(u);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<Users>)sessionFactory.getCurrentSession().createQuery("from Users where role_id = 3").list();
	}

	public Users getUser(int user_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Users.class, user_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getActiveUsers() {
		// TODO Auto-generated method stub
		return (List<Users>) sessionFactory.getCurrentSession().createQuery("from Users where Active = TRUE").list();
	}

}

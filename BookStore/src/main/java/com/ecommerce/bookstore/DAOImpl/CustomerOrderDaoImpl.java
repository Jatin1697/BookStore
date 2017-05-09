/*package com.ecommerce.bookstore.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.CustomerOrderDAO;
import com.ecommerce.bookstore.model.CustomerOrder;

@Transactional
@Repository(value="customerOrderDao")
public class CustomerOrderDaoImpl implements CustomerOrderDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void addOrder(CustomerOrder custOrder) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(custOrder);
	}

	@Override
	public void updateOrder(CustomerOrder custOrder) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(custOrder);
	}

	@Override
	public boolean deleteOrder(CustomerOrder custOrder) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(custOrder);
		return false;
	}

	@Override
	public CustomerOrder getCustomerOrder(int order_id) {
		// TODO Auto-generated method stub
		return (CustomerOrder) sessionFactory.getCurrentSession().get(CustomerOrder.class, order_id);
	}

}
*/
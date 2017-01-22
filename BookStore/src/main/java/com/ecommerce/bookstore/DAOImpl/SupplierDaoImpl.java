package com.ecommerce.bookstore.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.bookstore.DAO.SupplierDao;
import com.ecommerce.bookstore.model.Supplier;

@Transactional
@Repository(value="supplierDao")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(supplier);
	}

	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(supplier);
	}

	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(supplier);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return (List<Supplier>)sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier getSupplier(int supplier_id) {
		// TODO Auto-generated method stub
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, supplier_id);
	}

}

package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Supplier;

public interface SupplierDao {

	public void addSupplier (Supplier supplier);
	public void updateSupplier (Supplier supplier);
	public boolean deleteSupplier (Supplier supplier);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplier(int supplier_id);
	
}

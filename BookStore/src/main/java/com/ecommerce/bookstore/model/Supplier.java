package com.ecommerce.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Supplier")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5148052240840182976L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int supplier_id;
	
	@Column
	String supplier_name;
	String supplier_mob_no;
	String supplier_address;
	String supplier_email;
	/**
	 * @return the supplier_id
	 */
	public int getSupplier_id() {
		return supplier_id;
	}
	/**
	 * @param supplier_id the supplier_id to set
	 */
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	/**
	 * @return the supplier_name
	 */
	public String getSupplier_name() {
		return supplier_name;
	}
	/**
	 * @param supplier_name the supplier_name to set
	 */
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	/**
	 * @return the supplier_mob_no
	 */
	public String getSupplier_mob_no() {
		return supplier_mob_no;
	}
	/**
	 * @param supplier_mob_no the supplier_mob_no to set
	 */
	public void setSupplier_mob_no(String supplier_mob_no) {
		this.supplier_mob_no = supplier_mob_no;
	}
	/**
	 * @return the supplier_address
	 */
	public String getSupplier_address() {
		return supplier_address;
	}
	/**
	 * @param supplier_address the supplier_address to set
	 */
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	/**
	 * @return the supplier_email
	 */
	public String getSupplier_email() {
		return supplier_email;
	}
	/**
	 * @param supplier_email the supplier_email to set
	 */
	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}
	
}

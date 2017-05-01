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
@Table(name="ShippingDetails")
public class ShippingDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7390020433742057360L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String shipping_address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	
}

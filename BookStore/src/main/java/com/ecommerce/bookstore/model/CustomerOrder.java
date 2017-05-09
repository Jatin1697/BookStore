/*package com.ecommerce.bookstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Order")
public class CustomerOrder implements Serializable {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -938908495963596445L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String username;
	int quantity;
	int grand_total;
	@ElementCollection
	@CollectionTable(name="Ordered_products" , joinColumns = @JoinColumn(name="id"))
	@Column(name="product_name")
	List<String> product_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(int grand_total) {
		this.grand_total = grand_total;
	}
	public List<String> getProduct_name() {
		return product_name;
	}
	public void setProduct_name(List<String> product_name) {
		this.product_name = product_name;
	}
	
	
}
*/
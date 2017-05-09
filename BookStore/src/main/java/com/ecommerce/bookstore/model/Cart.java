package com.ecommerce.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Cart")
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2112506431466926325L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cart_id;
	@Column
	@Min(0)
	int quantity;
	double total_price;
	boolean flag = false;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id" , referencedColumnName="user_id")
	private Users users;
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name="product_id" , referencedColumnName="product_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

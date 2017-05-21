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

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Wishlist")
public class Wishlist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -811594158680804308L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int wishlist_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id" , referencedColumnName="user_id")
	private Users users;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="product_id" , referencedColumnName="product_id")
	private Product product;

	public int getWishlist_id() {
		return wishlist_id;
	}

	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}

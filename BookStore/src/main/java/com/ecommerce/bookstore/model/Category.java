package com.ecommerce.bookstore.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Category")
@Component
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4580496982069880509L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_id;
	
	@Column
	String category_name;

	@OneToMany(mappedBy = "category" , cascade=CascadeType.ALL)
	private Set<Product> product;
	
	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

		
}

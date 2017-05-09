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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Users")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -20346868166782586L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	@Column(unique=true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private int role_id = 3;
	
	@Column
	private boolean Active=false;
	private String email;
	private String mobile;
	private String address;
	
	@OneToMany(mappedBy="users" , cascade = CascadeType.ALL)
	private Set<Cart> cart;
	
	public Set<Cart> getCart() {
		return cart;
	}
	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	
	@Transient
	private MultipartFile user_image;
	public MultipartFile getUser_image() {
		return user_image;
	}
	public void setUser_image(MultipartFile user_image) {
		this.user_image = user_image;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}

package com.ecommerce.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Roles implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2317596537106812895L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_role_id;
	
	@Column
	private String role="ROLE_USER";
	
	@Column
	private int user_id;

	/**
	 * @return the user_role_id
	 */
	public int getUser_role_id() {
		return user_role_id;
	}

	/**
	 * @param user_role_id the user_role_id to set
	 */
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
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
}

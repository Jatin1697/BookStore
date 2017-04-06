package com.ecommerce.bookstore.DAO;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ecommerce.bookstore.model.Users;

public interface UserDao {
	
	public void addUser(Users u);
	@PreAuthorize("hasRole('ROLE_USER')")
	public void updateUser (Users u);
	public boolean deleteUser (Users u);
	public List<Users> getAllUsers();
	public Users getUser(int user_id);
	public List<Users> getActiveUsers();
	public List<Users> getUsersOnly();
	public Users getUserByUsername(String username);
}

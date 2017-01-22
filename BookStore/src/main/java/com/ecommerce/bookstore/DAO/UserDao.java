package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Users;

public interface UserDao {
	
	public void addUser(Users u);
	public void updateUser (Users u);
	public boolean deleteUser (Users u);
	public List<Users> getAllUsers();
	public Users getUser(int user_id);
}

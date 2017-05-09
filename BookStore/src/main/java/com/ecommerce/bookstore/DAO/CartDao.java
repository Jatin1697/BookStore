package com.ecommerce.bookstore.DAO;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ecommerce.bookstore.model.Cart;

public interface CartDao {
	
	@PreAuthorize("hasRole('USER')")
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCartItems(int user_id);
	public Cart getCart(int cart_id);

}

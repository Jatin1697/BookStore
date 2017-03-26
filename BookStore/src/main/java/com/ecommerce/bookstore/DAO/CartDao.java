package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Cart;

public interface CartDao {
	
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCartItems(String username);
	public Cart getCart(int cart_id);

}

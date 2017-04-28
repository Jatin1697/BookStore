package com.ecommerce.bookstore.DAO;

import java.util.List;

import com.ecommerce.bookstore.model.Wishlist;

public interface WishlistDao {

	public void addWishlist(Wishlist wishlist);
	public void updateWishlist(Wishlist wishlist);
	public boolean deleteWishlist(Wishlist wishlist);
	public List<Wishlist> getWishlistItems(String username);
	public Wishlist getWishlist(int wishlist_id);
}

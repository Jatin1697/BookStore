package com.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.DAO.WishlistDao;



@Controller
@RequestMapping("/user")
public class WishlistController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	WishlistDao wishlistDao;
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value="/{username}/wishlist" , method = RequestMethod.GET)
	public String wishlist(@PathVariable("username") String username , ModelMap model)
	{
		if(!username.equals(getPrincipal()))
			return "redirect:/logout";
		
		model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("products",wishlistDao.getWishlistItems(userDao.getUserByUsername(username).getUser_id()));
    	
		return "wishlist";
	}
	
	
	
	@RequestMapping(value="/{username}/wishlist/remove-wishlist/{wishlist_id}", method = RequestMethod.GET)
    public String removeCart(@PathVariable int wishlist_id , ModelMap model)
    {
    	wishlistDao.deleteWishlist(wishlistDao.getWishlist(wishlist_id));
    	model.addAttribute("username", getPrincipal());
    	return "redirect:/user/{username}/wishlist";
    }
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}

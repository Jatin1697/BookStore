package com.ecommerce.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.DAO.WishlistDao;
import com.ecommerce.bookstore.model.Product;
import com.ecommerce.bookstore.model.Wishlist;

@Controller
public class WishlistController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	WishlistDao wishlistDao;
	
	@Autowired
	ProductDao productDao;

	@RequestMapping(value="/wishlist" , method = RequestMethod.GET)
	public String wishlist(@RequestParam("username") String username , ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("products",wishlistDao.getWishlistItems(username));
    	
		return "wishlist";
	}
	
	@RequestMapping(value="/addWishlistItem" , method = RequestMethod.GET)
	public String addItemToWishlist(@RequestParam("book") String book , ModelMap model)
	{
		if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
    	{
    		return "redirect:/login";
    	}
		
		List<Wishlist> wishlist1 = wishlistDao.getWishlistItems(getPrincipal());
		for(Wishlist list : wishlist1)
		{
			if(list.getProduct_name().equals(book))
			{
				model.addAttribute("username", getPrincipal());
				return "redirect:/wishlist";
			}
		}
		
		System.out.println(book);
		Product product = productDao.getProductByName(book);
		Wishlist wishlist = new Wishlist();
		wishlist.setAuthor(product.getAuthor());
		wishlist.setProduct_name(book);
		wishlist.setDescription(product.getDescription());
		wishlist.setUsername(getPrincipal());
		wishlistDao.addWishlist(wishlist);
		model.addAttribute("username", getPrincipal());
		return "redirect:/wishlist";
	}
	
	@RequestMapping(value="remove-wishlist-{wishlist_id}", method = RequestMethod.GET)
    public String removeCart(@PathVariable int wishlist_id , ModelMap model)
    {
    	wishlistDao.deleteWishlist(wishlistDao.getWishlist(wishlist_id));
    	model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("products",wishlistDao.getWishlistItems(getPrincipal()));
    	return "wishlist";
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

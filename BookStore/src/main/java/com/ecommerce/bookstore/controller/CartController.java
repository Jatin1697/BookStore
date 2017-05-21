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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.bookstore.DAO.CartDao;
import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Cart;
import com.ecommerce.bookstore.model.Product;

@Controller
@RequestMapping("/user")
public class CartController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;

    @RequestMapping(value="/{username}/cart", method = RequestMethod.GET)
    public String shoppingCart(@PathVariable("username") String username , ModelMap model)// , @RequestParam("msg") String msg )
    {
    	if(!username.equals(getPrincipal())){
    		System.out.println(username);
    		return "redirect:/logout";
    	}
    		
    	model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("products",cartDao.getCartItems(userDao.getUserByUsername(username).getUser_id()));
    	//model.addAttribute("msg", msg);
    	
    	return "cart";
    }
    
    
    
    @RequestMapping(value="/{username}/cart/remove-cart/{cart_id}", method = RequestMethod.GET)
    public String removeCart(@PathVariable int cart_id , ModelMap model)
    {
    	cartDao.deleteCart(cartDao.getCart(cart_id));
    	model.addAttribute("username", getPrincipal());
		
    	return "redirect:/user/{username}/cart";
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

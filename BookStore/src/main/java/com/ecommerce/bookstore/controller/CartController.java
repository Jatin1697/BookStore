package com.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.bookstore.DAO.CartDao;
import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Cart;
import com.ecommerce.bookstore.model.Product;

@Controller
public class CartController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;

    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public String shoppingCart(@RequestParam("username") String username , ModelMap model)
    {
		model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("products",cartDao.getCartItems(username));
    	
    	return "cart";
    }
    
    @RequestMapping(value="addCartItem" , method = RequestMethod.GET)
    public String addProductToCart(@RequestParam("book") String book , ModelMap model)
    {
    	if(getPrincipal() == "anonymousUser")
    	{
    		return "redirect:/login";
    	}
    	
    	Cart cart = new Cart();
    	Product product = productDao.getProductByName(book);
    	cart.setProduct_name(book);
    	cart.setPrice(product.getPrice());
    	cart.setQuantity(1);
    	cart.setUsername(getPrincipal());
    	model.addAttribute("username", getPrincipal());
    	
    	cartDao.addCart(cart);
    	return "redirect:/cart";
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

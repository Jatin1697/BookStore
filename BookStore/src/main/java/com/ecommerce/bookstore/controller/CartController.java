package com.ecommerce.bookstore.controller;

import java.util.List;

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
    	
    	Product product = productDao.getProductByName(book);
    	
    	if(product.getQuantity() == 0)
    	{
			model.addAttribute("msg", "This product is out of stock from this seller. Check another seller to buy this product");
			model.addAttribute("username", getPrincipal());
			return "redirect:/cart";
    	}
    	List<Cart> list = cartDao.getCartItems(getPrincipal());
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++)
    	{
    		if(list.get(i).getProduct_name().equals(book))
    		{
    			int j=1; //variable created to increase the quantity of product in cart by 1
    			
    			Cart cart = cartDao.getCart(list.get(i).getCart_id());
    			if(cart.getQuantity() == product.getQuantity())
    			{
    				j=0;
    				model.addAttribute("msg", "This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    			}
    			cart.setQuantity(cart.getQuantity()+j);
    			cart.setProduct_name(book);
    	    	
    	    	// set the price after discount
    	    	int price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
    	    	
    	    	cart.setPrice(price);
    	    	cart.setTotal_price(price*cart.getQuantity());
    	    	cart.setUsername(getPrincipal());
    	    	model.addAttribute("username", getPrincipal());
    			cartDao.updateCart(cart);
    			
    			return "redirect:/cart";
    		}
    	}
    	
    	Cart cart = new Cart();
    	
    	cart.setProduct_name(book);
    	
    	// set the price after discount; 
    	int price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
    	cart.setPrice(price);
    	
    	cart.setQuantity(1);
    	cart.setTotal_price(price);
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

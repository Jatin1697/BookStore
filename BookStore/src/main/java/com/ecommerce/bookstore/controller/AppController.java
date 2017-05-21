package com.ecommerce.bookstore.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.bookstore.DAO.CartDao;
import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.DAO.WishlistDao;
import com.ecommerce.bookstore.model.Cart;
import com.ecommerce.bookstore.model.Product;
import com.ecommerce.bookstore.model.Wishlist;
import com.google.gson.Gson;



@Controller
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	Wishlist wishlist;
	
	@Autowired
	WishlistDao wishlistDao;
	
	@Autowired
	Product product;
	
	Path path;
    
    @RequestMapping(value="/aboutUs", method = RequestMethod.GET)
    public String aboutUsPage(ModelMap model)
    {
    	model.addAttribute("Aboutus", "activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	return "about_us";
    }
    
    @RequestMapping(value="/contactUs", method = RequestMethod.GET)
    public String contactUsPage(ModelMap model)
    {
    	model.addAttribute("Contactus", "activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	return "contact_us";
    }
    
    @RequestMapping(value="/displayProduct/list/category-wise/{categoryId}" , method = RequestMethod.GET)
    public String displayProduct(ModelMap model , @PathVariable("categoryId") int categoryId )
    {
    	model.addAttribute("genre", "activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("books",productDao.getProductByCategory(categoryId));
    	return "displayProduct";
    }
    
    @RequestMapping(value="/displayProduct/list" , method=RequestMethod.GET)
    public String allProducts(ModelMap model)
    {
    	model.addAttribute("DisplayProduct","activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("books", productDao.getAllProducts());
    	return "displayProduct";
    }
    
    @RequestMapping(value={"/SearchController","/SearchController/*"}, method = RequestMethod.GET)
    public void searchProducts(@RequestParam("term") String product_name , ModelMap model , HttpServletResponse resp)
    {
    	List<String> list = productDao.getProductListByName(product_name);
    	String json = new Gson().toJson(list);
		try {
			resp.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/product" , method = RequestMethod.GET)
    public String viewProduct(ModelMap model , @RequestParam("search") String product_name )
    {
    	if(product_name.isEmpty() || productDao.getProductByName(product_name) == null)
    		return "redirect:/home";
    		
    	model.addAttribute("book",productDao.getProductByName(product_name));
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	
    	return "productPage";
    }
    
    @RequestMapping(value="/addCartItem" , method = RequestMethod.GET)
    public String addProductToCart(@RequestParam("book") String book , ModelMap model)// , RedirectAttributes redirectAttributes)
    {
    	if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
    	{
    		return "redirect:/login";
    	}
    	
    	Product product = productDao.getProductByName(book);
    	
    	if(product.getQuantity() == 0)
    	{
			model.addAttribute("username", getPrincipal());
			//model.addAttribute("msg",  "This product is out of stock from this seller. Check another seller to buy this product");
			//redirectAttributes.addFlashAttribute("msg", "This product is out of stock from this seller. Check another seller to buy this product");
			model.addAttribute("username", getPrincipal());
			return "redirect:/user/{username}/cart";
    	}
    	List<Cart> list = cartDao.getCartItems(userDao.getUserByUsername(getPrincipal()).getUser_id());
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++)
    	{
    		if(list.get(i).getProduct().getProduct_name().equals(book))
    		{
    			int j=1; //variable created to increase the quantity of product in cart by 1
    			
    			Cart cart = cartDao.getCart(list.get(i).getCart_id());
    			if(cart.getQuantity() == product.getQuantity())
    			{
    				j=0;
    				//model.addAttribute("msg","This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    				//redirectAttributes.addFlashAttribute("msg", "This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    			}
    			cart.setQuantity(cart.getQuantity()+j);
    	    	
    	    	// set the price after discount
    	    	int price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
    	    	
    	    	cart.setTotal_price(price*cart.getQuantity());
    	    	cart.setProduct(product);
    	    	cart.setUsers(userDao.getUserByUsername(getPrincipal()));
    	    	model.addAttribute("username", getPrincipal());
    			cartDao.updateCart(cart);
    			return "redirect:/user/{username}/cart";
    		}
    	}
    	
    	Cart cart = new Cart();
    	
    	// set the price after discount; 
    	int price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
    	
    	cart.setQuantity(1);
    	cart.setTotal_price(price);
    	cart.setProduct(product);
    	cart.setUsers(userDao.getUserByUsername(getPrincipal()));
    	model.addAttribute("username", getPrincipal());
    	
    	cartDao.addCart(cart);
    	return "redirect:/user/{username}/cart";
    }
    
    @RequestMapping(value="/addWishlistItem" , method = RequestMethod.GET)
	public String addItemToWishlist(@RequestParam("book") String book , ModelMap model)
	{
		if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
    	{
    		return "redirect:/login";
    	}
		
		List<Wishlist> wishlist1 = wishlistDao.getWishlistItems(userDao.getUserByUsername(getPrincipal()).getUser_id());
		for(Wishlist list : wishlist1)
		{
			if(list.getProduct().getProduct_name().equals(book))
			{
				model.addAttribute("username", getPrincipal());
				return "redirect:/user/{username}/wishlist";
			}
		}
		
		System.out.println(book);
		product = productDao.getProductByName(book);
		wishlist = new Wishlist();
		wishlist.setProduct(product);
		wishlist.setUsers(userDao.getUserByUsername(getPrincipal()));
		wishlistDao.addWishlist(wishlist);
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

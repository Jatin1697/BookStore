package com.ecommerce.bookstore.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.SupplierDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Category;
import com.ecommerce.bookstore.model.Product;
import com.ecommerce.bookstore.model.Supplier;
import com.ecommerce.bookstore.model.Users;
import com.ecommerce.bookstore.service.MailService;



@Controller
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value={"/","/home"} , method = RequestMethod.GET)
	public String landingPage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "index";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String goToLogin(){
		return "loginPage";
		
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String goToRegistration(ModelMap model){
		model.addAttribute("addUser", new Users());
		return "registrationPage";
		
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
	
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("addUser") Users user) {
    	userDao.addUser(user);
    	mailService.sendEmail(user);
    	
		return "loginPage";
    	
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    //PRODUCT PAGE CONTROLLER
    @RequestMapping(value = "/handleProduct", method = RequestMethod.GET)
    public String productPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
    	model.addAttribute("new_product",new Product());
    	
    	List<Category> category = categoryDao.getAllCategory();
    	model.addAttribute("category", category);
    	
    	List<Supplier> suppliers = supplierDao.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        
        return "product";
    }
    
    @RequestMapping(value="/newProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("new_product") Product product)
    {
    	productDao.addProduct(product);
    	return "redirect:/handleProduct";
    }
    
    @RequestMapping(value="/edit-product-{product_id}", method = RequestMethod.GET)
    public String editProduct (ModelMap model)
    {
    	
    	return "product";
    }
    
    @RequestMapping(value="/delete-product-{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	Product productId = productDao.getProduct(product_id);
		productDao.deleteProduct(productId );
    	return "redirect:/handleProduct";
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

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
import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.google.gson.Gson;



@Controller
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
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
    
    @SuppressWarnings("unused")
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

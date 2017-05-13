package com.ecommerce.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;
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
    
    @RequestMapping(value="/displayProduct-{categoryId}" , method = RequestMethod.GET)
    public String displayProduct(ModelMap model , @PathVariable("categoryId") int categoryId )
    {
    	model.addAttribute("genre", "activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("books",productDao.getProductByCategory(categoryId));
    	return "displayProduct";
    }
    
    @RequestMapping(value="/allProduct" , method=RequestMethod.GET)
    public String allProducts(ModelMap model)
    {
    	model.addAttribute("DisplayProduct","activ");
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	model.addAttribute("books", productDao.getAllProducts());
    	return "displayProduct";
    }
    
    @RequestMapping(value="/account" , method = RequestMethod.GET)
    public String youtAccount(@RequestParam("username") String username , ModelMap model)
    {
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	Users user = userDao.getUserByUsername(getPrincipal());
    	model.addAttribute("updateUser", user);
    	
    	return "userDetails";
    }
    
    @RequestMapping(value="/updatingAccount-{user_id}" , method = RequestMethod.POST)
    public String updateAccountDetails(@ModelAttribute("updateUser") Users user , ModelMap model , HttpServletRequest request)
    {
    	user.setActive(true);
    	userDao.updateUser(user);
    	
    	MultipartFile image = user.getUser_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/user/" + user.getUsername()+".png");
    	System.out.println(path);
    	if(image != null && !image.isEmpty())
    	{
    		try
    		{
    			image.transferTo(new File(path.toString()));
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	model.addAttribute("msg", "Details have been successfully updated");
    	return "redirect:/home";
    }
    
    @RequestMapping(value="/SearchController", method = RequestMethod.GET)
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

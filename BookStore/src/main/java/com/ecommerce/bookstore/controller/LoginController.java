package com.ecommerce.bookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	Path path;

	@RequestMapping(value={"/","/home"} , method = RequestMethod.GET)
	public String landingPage(ModelMap model , HttpServletRequest request){
		model.addAttribute("user", getPrincipal());
		
		model.addAttribute("categories", categoryDao.getAllCategory());
		model.addAttribute("products", productDao.getAllProducts());
		model.addAttribute("Home", "activ");
		
		return "index";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String goToLogin(ModelMap model){
		
		model.addAttribute("Login", "activ");
		return "loginPage";
		
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

	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	 }
	 
	 @RequestMapping(value="/registration", method=RequestMethod.GET)
		public String goToRegistration(ModelMap model){
			model.addAttribute("addUser", new Users());
			model.addAttribute("Registration", "activ");
			return "registrationPage";
			
		}
	    
	    @RequestMapping(value="/register" , method = RequestMethod.POST)
	    public String addUser(@Valid @ModelAttribute("addUser") Users user , BindingResult result ,HttpServletRequest request, ModelMap model)
	    {
	    	if(result.hasErrors())
	    	{
	    		model.addAttribute("msg", "! Please input valid data");
	    		return "registrationPage";
	    	}
	    	
	    	List<Users> users = userDao.getAllUsers();
	    	for(int i=0; i<users.size(); i++ )
	    	{
	    		if(user.getUsername().equals(users.get(i).getUsername()))
	    		{
	    			model.addAttribute("msg", "! Username alresdy exists");
	    			model.addAttribute("email", user.getEmail());
	    			model.addAttribute("mobile", user.getMobile());
	    			model.addAttribute("address", user.getAddress());
	    			return "registrationPage";
	    		}
	    		if(user.getEmail().equals(users.get(i).getEmail()))
	    		{
	    			model.addAttribute("msg", "! Email alresdy exists");
	    			model.addAttribute("username", user.getUsername());
	    			model.addAttribute("mobile", user.getMobile());
	    			model.addAttribute("address", user.getAddress());
	    			return "registrationPage";
	    		}
	    		if(user.getMobile().equals(users.get(i).getMobile()))
	    		{
	    			model.addAttribute("msg", "! Contact alresdy exists");
	    			model.addAttribute("username", user.getUsername());
	    			model.addAttribute("email", user.getEmail());
	    			model.addAttribute("address", user.getAddress());
	    			return "registrationPage";
	    		}
	    		
	    	}
	    	
	    	userDao.addUser(user);
	    	//mailService.sendEmail(user);
	    	
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
	    	
	    	return "redirect:/login";
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

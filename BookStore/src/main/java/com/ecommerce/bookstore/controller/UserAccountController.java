package com.ecommerce.bookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.bookstore.DAO.CategoryDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;

@Controller
@RequestMapping("/user")
public class UserAccountController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	Path path;

	@RequestMapping(value="/{username}/account" , method = RequestMethod.GET)
    public String youtAccount(@PathVariable("username") String username , ModelMap model)
    {
		if(!username.equals(getPrincipal()))
			return "redirect:/logout";
		
    	model.addAttribute("categories", categoryDao.getAllCategory());
    	Users user = userDao.getUserByUsername(getPrincipal());
    	model.addAttribute("user", user);
    	model.addAttribute("edit", false);
    	
    	return "userDetails";
    }
    
	@RequestMapping(value="/{username}/account/edit-details/{user_id}" , method = RequestMethod.GET)
	public String editAccountDetails(ModelMap model , @PathVariable("user_id") int user_id , @PathVariable("username") String username)
	{
		if(!username.equals(getPrincipal()))
			return "redirect:/logout";
		
		model.addAttribute("categories", categoryDao.getAllCategory());
    	Users user = userDao.getUser(user_id);
    	model.addAttribute("updateUser", user);
    	model.addAttribute("edit", true);
		return "userDetails";
	}
	
    @RequestMapping(value="/{username}/account/edit-details/updatingAccount/{user_id}" , method = RequestMethod.POST)
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
    	model.addAttribute("username", getPrincipal());
    	/*model.addAttribute("msg", "Details have been successfully updated");*/
    	return "redirect:/user/{username}/account";
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

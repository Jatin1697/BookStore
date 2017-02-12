package com.ecommerce.bookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Users;
import com.ecommerce.bookstore.service.MailService;



@Controller
public class AppController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MailService mailService;
	
	Path path;
	
	@RequestMapping(value={"/","/home"} , method = RequestMethod.GET)
	public String landingPage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "index";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String goToLogin(){
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

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String goToRegistration(ModelMap model){
		model.addAttribute("addUser", new Users());
		return "registrationPage";
		
	}
    
    @RequestMapping(value="/register" , method = RequestMethod.POST)
    public String addUser(@ModelAttribute("addUser") Users user , HttpServletRequest request)
    {
    	userDao.addUser(user);
    	//mailService.sendEmail(user);
    	
    	MultipartFile image = user.getUser_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/user/" + user.getName()+".png");
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
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
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

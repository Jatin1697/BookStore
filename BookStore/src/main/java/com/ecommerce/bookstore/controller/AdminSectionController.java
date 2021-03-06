package com.ecommerce.bookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.ecommerce.bookstore.DAO.ProductDao;
import com.ecommerce.bookstore.DAO.SupplierDao;
import com.ecommerce.bookstore.DAO.UserDao;
import com.ecommerce.bookstore.model.Category;
import com.ecommerce.bookstore.model.Product;
import com.ecommerce.bookstore.model.Supplier;
import com.ecommerce.bookstore.model.Users;

@Controller
public class AdminSectionController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired 
	Category category;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	Path path;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model,HttpSession session) {
		
		if(getPrincipal() == "anonymousUser")
    	{
    		return "redirect:/login";
    	}
		
        
      
        List<Users> users = userDao.getUsersOnly();
        model.addAttribute("users", users);
        session.setAttribute("role", "ROLE_ADMIN");
        model.addAttribute("edit", false);
        model.addAttribute("new_category", new Category());
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
        
        model.addAttribute("no_of_categories", categoryDao.getAllCategory().size());
        model.addAttribute("no_of_active_users", userDao.getUsersOnly().size());
        
        return "admin";
    }
	
	@RequestMapping(value="/admin/change-status-user/{user_id}" , method = RequestMethod.GET)
	public String changeUserStatus(@PathVariable int user_id)
	{
		Users user = userDao.getUser(user_id);
		if(user.isActive())
				user.setActive(false);
		else
				user.setActive(true);
		
		userDao.updateUser(user);
		return "redirect:/admin";
	}
	
	//PRODUCT PAGE CONTROLLER
    @RequestMapping(value = "/admin/handleProduct", method = RequestMethod.GET)
    public String productPage(ModelMap model) {
        
        model.addAttribute("edit", false);
    	model.addAttribute("new_product",new Product());
    	
    	List<Category> category = categoryDao.getAllCategory();
    	model.addAttribute("category", category);
    	
    	List<Supplier> suppliers = supplierDao.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        
        model.addAttribute("no_of_products", products.size());
        
        return "product";
    }
    
	@RequestMapping(value="/admin/newProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("new_product") Product product , HttpServletRequest request)
    {
		
		category = categoryDao.getCategory(product.getCategory().getCategory_id());
		supplier = supplierDao.getSupplier(product.getSupplier().getSupplier_id());
		
		product.setCategory(category);
		product.setSupplier(supplier);
		product.setDateTime(new Date());
    	productDao.addProduct(product);
    	
    	MultipartFile image = product.getProduct_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/product/" + product.getProduct_name()+".png");
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
    	
    	return "redirect:/admin/handleProduct";
    }
    
    @RequestMapping(value="/admin/edit-product/{product_id}", method = RequestMethod.GET)
    public String editProduct (@PathVariable int product_id , ModelMap model)
    {
    	Product product = productDao.getProduct(product_id);
    	System.out.println("product_id" + product_id);
    	model.addAttribute("edit", true);
    	model.addAttribute("update_product",product);
    	
    	model.addAttribute("product_id", product_id);
    	
    	List<Category> category = categoryDao.getAllCategory();
    	model.addAttribute("category", category);
    	
    	List<Supplier> suppliers = supplierDao.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        
        model.addAttribute("no_of_products", productDao.getAllProducts().size());
        
    	return "product";
    }
    
    @RequestMapping(value="/admin/edit-product/update-product/{product_id}" , method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("update_product") Product product , HttpServletRequest request)
    {
    	category = categoryDao.getCategory(product.getCategory().getCategory_id());
		supplier = supplierDao.getSupplier(product.getSupplier().getSupplier_id());
		
		product.setCategory(category);
		product.setSupplier(supplier);
		product.setDateTime(new Date());
		productDao.updateProduct(product);
		
		MultipartFile image = product.getProduct_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/product/" + product.getProduct_name()+".png");
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
    	
    	return "redirect:/admin/handleProduct";
    }
    
    @RequestMapping(value="/admin/delete-product/{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	Product productId = productDao.getProduct(product_id);
		productDao.deleteProduct(productId );
    	return "redirect:/admin/handleProduct";
    }
    
    //CATEGORY CONTROLLER
    @RequestMapping(value="/admin/newCategory", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("new_category") Category category)
    {
    	categoryDao.addCategory(category);
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/admin/delete-category/{category_id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int category_id)
    {
    	categoryDao.deleteCategory(categoryDao.getCategory(category_id));
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/admin/edit-category/{category_id}" , method = RequestMethod.GET)
    public String editCategory(@PathVariable int category_id , ModelMap model)
    {
    	Category category = categoryDao.getCategory(category_id);
    	model.addAttribute("category_id", category_id);
    	model.addAttribute("update_category", category);
    	model.addAttribute("edit", true);
    	
    	List<Users> users = userDao.getUsersOnly();
        model.addAttribute("users", users);
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
    	
        model.addAttribute("no_of_categories", categoryDao.getAllCategory().size());
        model.addAttribute("no_of_active_users", userDao.getUsersOnly().size());
        
    	return "admin";
    }
    
    @RequestMapping(value="/admin/edit-category/update-category/{category_id}" , method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("update_category") Category category)
    {
    	categoryDao.updateCategory(category);
    	return "redirect:/admin";
    }
    
    //SUPPLIER CONTROLLER
    @RequestMapping(value="/admin/handleSupplier" , method = RequestMethod.GET)
    public String supplierPage(ModelMap model)
    {
    	
    	model.addAttribute("edit", false);
    	model.addAttribute("no_of_suppliers", supplierDao.getAllSuppliers().size());
    	model.addAttribute("new_supplier", new Supplier());
    	model.addAttribute("suppliers", supplierDao.getAllSuppliers());
    	return "supplier";
    }
    
    @RequestMapping(value="/admin/delete-supplier/{supplier_id}" , method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int supplier_id)
    {
    	supplierDao.deleteSupplier(supplierDao.getSupplier(supplier_id));
    	return "redirect:/admin/handleSupplier";
    }
    
    @RequestMapping(value="/admin/newSupplier" , method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("new_supplier") Supplier supplier)
    {
    	supplierDao.addSupplier(supplier);
    	return "redirect:/admin/handleSupplier";
    }
	
    @RequestMapping(value="/admin/edit-supplier/{supplier_id}" , method = RequestMethod.GET)
    public String editSupplier(@PathVariable int supplier_id , ModelMap model)
    {
    	Supplier supplier1 = supplierDao.getSupplier(supplier_id);
    	
    	model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplier1);
    	model.addAttribute("suppliers", supplierDao.getAllSuppliers());
    	
    	return "supplier";
    }
    
    @RequestMapping(value="/admin/edit-supplier/update-supplier/{supplier_id}" , method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("update_supplier") Supplier supplier)
    {
    	supplierDao.updateSupplier(supplier);
    	return "redirect:/admin/handleSupplier";
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

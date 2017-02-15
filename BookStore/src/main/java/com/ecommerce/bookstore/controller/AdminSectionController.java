package com.ecommerce.bookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	SupplierDao supplierDao;
	
	Path path;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
      
        List<Users> users = userDao.getUsersOnly();
        model.addAttribute("users", users);
        
        model.addAttribute("edit", false);
        model.addAttribute("new_category", new Category());
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
        
        model.addAttribute("no_of_categories", categoryDao.getAllCategory().size());
        model.addAttribute("no_of_active_users", userDao.getUsersOnly().size());
        
        return "admin";
    }
	
	@RequestMapping(value="/change-status-user-{user_id}" , method = RequestMethod.GET)
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
        
        model.addAttribute("no_of_products", products.size());
        
        return "product";
    }
    
	@RequestMapping(value="/newProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("new_product") Product product , @RequestParam("category") String category_name , HttpServletRequest request)
    {
		Category category = categoryDao.getCategoryByName(category_name);
		product.setCategory(category);
		
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
    	
    	return "redirect:/handleProduct";
    }
    
    @RequestMapping(value="/edit-product-{product_id}", method = RequestMethod.GET)
    public String editProduct (@PathVariable int product_id , ModelMap model)
    {
    	Product product = productDao.getProduct(product_id);
    	
    	model.addAttribute("user", getPrincipal());
    	model.addAttribute("edit", true);
    	model.addAttribute("update_product",product);
    	
    	model.addAttribute("name", product.getProduct_name());
    	model.addAttribute("description", product.getDescription());
    	model.addAttribute("author", product.getAuthor());
    	model.addAttribute("price", product.getPrice());
    	model.addAttribute("quantity", product.getQuantity());
    	
    	List<Category> category = categoryDao.getAllCategory();
    	model.addAttribute("category", category);
    	
    	List<Supplier> suppliers = supplierDao.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        
        model.addAttribute("no_of_products", productDao.getAllProducts().size());
    	return "product";
    }
    
    @RequestMapping(value="/delete-product-{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	Product productId = productDao.getProduct(product_id);
		productDao.deleteProduct(productId );
    	return "redirect:/handleProduct";
    }
    
    //CATEGORY CONTROLLER
    @RequestMapping(value="/newCategory", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("new_category") Category category)
    {
    	categoryDao.addCategory(category);
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/delete-category-{category_id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int category_id)
    {
    	categoryDao.deleteCategory(categoryDao.getCategory(category_id));
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/edit-category-{category_id}" , method = RequestMethod.GET)
    public String editCategory(@PathVariable int category_id , ModelMap model)
    {
    	Category category = categoryDao.getCategory(category_id);
    	model.addAttribute("category_id", category_id);
    	model.addAttribute("update_category", category);
    	model.addAttribute("categoryName", category.getCategory_name());
    	model.addAttribute("edit", true);
    	
    	List<Users> users = userDao.getUsersOnly();
        model.addAttribute("users", users);
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
    	
        model.addAttribute("no_of_categories", categoryDao.getAllCategory().size());
        model.addAttribute("no_of_active_users", userDao.getUsersOnly().size());
        
    	return "admin";
    }
    
    @RequestMapping(value="/edit-category-{category_id}" , method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("update_category") Category category)
    {
    	categoryDao.updateCategory(category);
    	return "redirect:/admin";
    }
    
    //SUPPLIER CONTROLLER
    @RequestMapping(value="/handleSupplier" , method = RequestMethod.GET)
    public String supplierPage(ModelMap model)
    {
    	model.addAttribute("user", getPrincipal());
    	model.addAttribute("edit", false);
    	model.addAttribute("no_of_suppliers", supplierDao.getAllSuppliers().size());
    	model.addAttribute("new_supplier", new Supplier());
    	model.addAttribute("suppliers", supplierDao.getAllSuppliers());
    	return "supplier";
    }
    
    @RequestMapping(value="/delete-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int supplier_id)
    {
    	supplierDao.deleteSupplier(supplierDao.getSupplier(supplier_id));
    	return "redirect:/handleSupplier";
    }
    
    @RequestMapping(value="/newSupplier" , method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("new_supplier") Supplier supplier)
    {
    	supplierDao.addSupplier(supplier);
    	return "redirect:/handleSupplier";
    }
	
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String editSupplier(@PathVariable int supplier_id , ModelMap model)
    {
    	Supplier supplier1 = supplierDao.getSupplier(supplier_id);
    	
    	model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplier1);
    	model.addAttribute("suppliers", supplierDao.getAllSuppliers());
    	model.addAttribute("name", supplier1.getSupplier_name());
    	model.addAttribute("address", supplier1.getSupplier_address());
    	model.addAttribute("email", supplier1.getSupplier_email());
    	model.addAttribute("mob_no", supplier1.getSupplier_mob_no());
    	
    	return "supplier";
    }
    
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("update_supplier") Supplier supplier)
    {
    	supplierDao.updateSupplier(supplier);
    	return "redirect:/handleSupplier";
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

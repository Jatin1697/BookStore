package com.ecommerce.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        
        List<Users> users = userDao.getActiveUsers();
        model.addAttribute("users", users);
        
        model.addAttribute("edit", false);
        model.addAttribute("new_category", new Category());
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
        
        return "admin";
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
    	
    	List<Users> users = userDao.getActiveUsers();
        model.addAttribute("users", users);
        
        List<Category> categories = categoryDao.getAllCategory();
        model.addAttribute("categories", categories);
    	
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
    	model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplierDao.getSupplier(supplier_id));
    	model.addAttribute("suppliers", supplierDao.getAllSuppliers());
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

package com.blueconch.EcommerceWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.model.Category;
import com.blueconch.EcommerceWebsite.services.CategoriesService;
import com.blueconch.EcommerceWebsite.services.ProductsService;

@RestController
@RequestMapping("EcommerceAPI/")
public class CategoriesController {

	@Autowired
	private CategoriesService service;
	
	@Autowired
	private ProductsService productService;
	
	@GetMapping("public/categories")
	public List<Category> getCategories() {
		return service.getCategories();
	}

	@GetMapping("public/categories/{categoryId}")
	public Category getCategory(@PathVariable int categoryId) {
		return service.getCategory(categoryId);
	}
	
    //only for admin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("categories/admin")
	public void addCategory(@RequestBody Category category) {
		service.addCategory(category);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("categories/admin/{categoryId}")
	public void updatecategory(@RequestBody Category category) {
		service.updateCategory(category);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("categories/admin/{categoryId}")
	public void deletecategory(@PathVariable int categoryId) {
		productService.deleteProduct(categoryId);
		service.deletecategory(categoryId);
	}
	
	
		
}

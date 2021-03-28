package com.blueconch.EcommerceWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.model.ProductDetail;
import com.blueconch.EcommerceWebsite.services.ProductDetailsService;


@RestController
@RequestMapping("EcommerceAPI/")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService service;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("products/{productId}/productDetails")
	public List<ProductDetail> getProductDetailsByProduct(@PathVariable int productId){
		return service.getProductDetailsByProductId(productId);
	}
	
	//for admin or business user
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/productDetails")
	public List<ProductDetail> getProductDetails(){
		return service.getProductDetails();
	}
}

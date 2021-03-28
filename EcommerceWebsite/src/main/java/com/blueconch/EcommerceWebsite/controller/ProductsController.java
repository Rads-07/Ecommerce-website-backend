package com.blueconch.EcommerceWebsite.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.DTO.ProductDTO;
import com.blueconch.EcommerceWebsite.model.Product;
import com.blueconch.EcommerceWebsite.services.ProductsService;

@RestController
@RequestMapping("/EcommerceAPI")
public class ProductsController {

	@Autowired
	private ProductsService service;

	@GetMapping("/public/products")
	public List<ProductDTO> getProducts() {
		List<Product> products = service.getProducts();

		return products.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/public/categories/{categoryId}/products")
	public List<ProductDTO> getProductsByCategoryId(@PathVariable int categoryId) {
		List<Product> products = service.getProductsByCategoryId(categoryId);

		return products.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/public/products/{productId}")
	public ProductDTO getProduct(@PathVariable int productId) {
		Product product = service.getProduct(productId);
		return convertToDto(product);
	}

	// only for admin or business user
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}

	// only for admin or business user
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/products/{productId}")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}

	// only for admin or business user
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		service.deleteProduct(productId);
	}

	private ProductDTO convertToDto(Product product) {
		ProductDTO productDTO = new ModelMapper().map(product, ProductDTO.class);
		return productDTO;
	}

}

package com.blueconch.EcommerceWebsite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Product;
import com.blueconch.EcommerceWebsite.repository.ProductsRepo;

@Service
public class ProductsService  {
	@Autowired
	ProductsRepo repo;
	
	@Transactional
	public List<Product> getProducts(){
		
		List<Product> products = new ArrayList<>();
		for(Product product: repo.findAll()) {
			products.add(product);
		}
		return products;
	}
	
	@Transactional
	public Product getProduct(int productId) {
		return repo.findById(productId).get();
	}
	
	@Transactional
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		repo.save(product);
	}
	
	@Transactional
	public void deleteProduct(int productId){
		repo.deleteById(productId);	
	}

	@Transactional
	public List<Product> getProductsByCategoryId(int categoryId) {
		return repo.getProductsByCategoryId(categoryId);
	}

}

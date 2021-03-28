package com.blueconch.EcommerceWebsite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.ProductDetail;
import com.blueconch.EcommerceWebsite.repository.ProductDetailsRepo;

@Service
public class ProductDetailsService {

	@Autowired
	ProductDetailsRepo repo;
	
	@Transactional
	public List<ProductDetail> getProductDetailsByProductId(int productId) {
		return repo.getProductDetailByProductId(productId);
	}
	
	@Transactional
	public List<ProductDetail> getProductDetails() {
		List<ProductDetail> productDetails = new ArrayList<>();
		for(ProductDetail productDetail: repo.findAll()) {
			productDetails.add(productDetail);
		}
		return productDetails;
	}
	
	
}

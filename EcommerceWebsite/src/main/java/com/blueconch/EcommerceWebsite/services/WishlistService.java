package com.blueconch.EcommerceWebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Wishlist;
import com.blueconch.EcommerceWebsite.repository.WishlistRepo;

@Service
public class WishlistService {
	
	@Autowired
	WishlistRepo repo;

	@Transactional
	public List<Wishlist> getWishlists(int userId) {
		return repo.findAllByuserId(userId);
	}
	
	@Transactional
	public Wishlist addWishlist(Wishlist wishlist) {
		return repo.save(wishlist);
	}

	@Transactional
	public void deleteWishlist(int userId) {
		repo.deleteByuserId(userId);
	}
	
	@Transactional
	public void deleteWishlistProduct(int userId, int productId) {
		repo.deleteByuserIdandProductId(userId, productId);
		
	}

}

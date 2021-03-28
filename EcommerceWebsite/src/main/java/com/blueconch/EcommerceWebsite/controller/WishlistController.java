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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.DTO.WishlistDTO;
import com.blueconch.EcommerceWebsite.model.Wishlist;
import com.blueconch.EcommerceWebsite.services.WishlistService;


@RestController
@RequestMapping("EcommerceAPI/wishlist") //for user after login only
public class WishlistController {
	
	@Autowired
	WishlistService service;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/{userId}")
	public List<WishlistDTO> getWishlists(@PathVariable int userId) {
		List<Wishlist> wishlist = service.getWishlists(userId);
		return wishlist.stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());	
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping
	public WishlistDTO addWishlist(@RequestBody WishlistDTO wishlistDTO ){
		Wishlist wishlist = convertToEntity(wishlistDTO);
		return convertToDto(service.addWishlist(wishlist));
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/{userId}")
	public void deleteWishlist(@PathVariable int userId) {
		service.deleteWishlist(userId);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/{userId}/productId")
	public void deleteWishlist(@PathVariable int userId, @RequestParam("value") int productId) {
		service.deleteWishlistProduct(userId,productId);
	}

	private WishlistDTO convertToDto(Wishlist wishlist) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		//modelMapper.typeMap(Wishlist.class, WishlistDTO.class).addMapping(Wishlist-> Wishlist.getProduct().getProductId(), WishlistDTO::setProductId);
		WishlistDTO wishlistDTO =  modelMapper.map(wishlist, WishlistDTO.class);
		wishlistDTO.setProductId(wishlist.getProduct().getProductId());
		return wishlistDTO;

    }
	
	private Wishlist convertToEntity(WishlistDTO wishlistDTO) {
	
        return new ModelMapper().map(wishlistDTO, Wishlist.class);
    }

}

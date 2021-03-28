package com.blueconch.EcommerceWebsite.DTO;


public class WishlistDTO {

	private int wishlistId;
	private int userId;
	private int productId;
	private int productDetailId;
	private int quantity;
	
	public WishlistDTO() {
	}

	public WishlistDTO(int wishlistId, int userId, int productId, int productDetailId, int quantity) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
		this.productDetailId = productDetailId;
		this.quantity = quantity;
	}
	
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductDetailId() {
		return productDetailId;
	}
	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

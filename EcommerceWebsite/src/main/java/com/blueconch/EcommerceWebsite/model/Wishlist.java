package com.blueconch.EcommerceWebsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wishlist_id")
	private int wishlistId;
	
	@Column(name="user_id")
	private int userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Product product;

	@Column(name="product_detail_id")
	private int productDetailId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="date_of_creation" , insertable=false)
	private Date dateOfCreation ;

	public Wishlist() {
		}

	public Wishlist(int wishlistId, int userId, Product product, int productDetailId, int quantity,
			Date dateOfCreation) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.product = product;
		this.productDetailId = productDetailId;
		this.quantity = quantity;
		this.dateOfCreation = dateOfCreation;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

}

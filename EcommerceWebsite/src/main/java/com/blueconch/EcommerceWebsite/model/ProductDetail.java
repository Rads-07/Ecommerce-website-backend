package com.blueconch.EcommerceWebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_detail_id")
	private int productDetailId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="size")
	private String size;
	
	@Column(name="color")
	private String color;
	
	@Column(name="gender")
	private String gender;

	public ProductDetail() {
	}

	public ProductDetail(int productDetailId, int productId, String size, String color, String gender) {
		super();
		this.productDetailId = productDetailId;
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.gender = gender;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "ProductDetail [productDetailId=" + productDetailId + ", productId=" + productId + ", size=" + size
				+ ", color=" + color + ", gender=" + gender + "]";
	}

}

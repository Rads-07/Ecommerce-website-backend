package com.blueconch.EcommerceWebsite.DTO;

public class ProductDTO {

	private String productName;
	private String productDescription;
	private int price;
	private int stockAvailable;
	private String image;
	public ProductDTO() {
	}
	public ProductDTO(String productName, String productDescription, int price, int stockAvailable, String image) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.stockAvailable = stockAvailable;
		this.image = image;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockAvailable() {
		return stockAvailable;
	}
	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}

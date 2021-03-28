package com.blueconch.EcommerceWebsite.DTO;

public class AddressDTO {
	private int addressId;
	private int userId;
	private String fullName;
	private String address;
	private String postcode;
	private String city;
	private String state;
	private String country;
	private String mobileNo;
	private boolean isPermanent;
	public AddressDTO() {
	}
	public AddressDTO(int addressId, int userId, String fullName, String address, String postcode, String city,
			String state, String country, String mobileNo, boolean isPermanent) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.fullName = fullName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mobileNo = mobileNo;
		this.isPermanent = isPermanent;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public boolean isPermanent() {
		return isPermanent;
	}
	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	
}

package com.blueconch.EcommerceWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Address;
import com.blueconch.EcommerceWebsite.repository.AddressRepo;

@Service
public class AddressService {

	@Autowired
	public AddressRepo repo;

	@Transactional
	public Address getAddressByUserId(int userId) {
		return repo.getAddressByUserId(userId);
	}

	@Transactional
	public Address addAddress(Address address) {
		return repo.save(address);
	}
	
}

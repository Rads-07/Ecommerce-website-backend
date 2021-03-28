package com.blueconch.EcommerceWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Order;
import com.blueconch.EcommerceWebsite.repository.OrderRepo;

@Service
public class OrderService {


	@Autowired
	public OrderRepo repo;
	
	@Transactional
	public Order getOrderByUserId(int userId) {
		return repo.getOrderByUserId(userId);
	}

}

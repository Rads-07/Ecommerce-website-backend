package com.blueconch.EcommerceWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.model.Order;
import com.blueconch.EcommerceWebsite.services.OrderService;

@RestController
@RequestMapping("EcommerceAPI/")
public class OrderController {

	@Autowired
	public OrderService service;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/{userId}/orders")
	public Order getOrdersByUserId(@PathVariable int userId) {
		return service.getOrderByUserId(userId); 
	}
	
}

package com.blueconch.EcommerceWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blueconch.EcommerceWebsite.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query(value="select * from addresses where user_id=?1", nativeQuery = true)
	Address getAddressByUserId(int userId);

}

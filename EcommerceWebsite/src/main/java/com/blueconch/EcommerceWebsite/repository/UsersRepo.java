package com.blueconch.EcommerceWebsite.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.blueconch.EcommerceWebsite.model.User;

public interface UsersRepo extends CrudRepository<User, Integer>{

	Optional<User>  findByUsername(String username);
	Boolean existsByUsername(String username);

}

package com.blueconch.EcommerceWebsite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.blueconch.EcommerceWebsite.model.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

	@Query(value ="select * from categories where category_name=?1", nativeQuery = true)
	Category getCategoryByName(String categoryName);

}

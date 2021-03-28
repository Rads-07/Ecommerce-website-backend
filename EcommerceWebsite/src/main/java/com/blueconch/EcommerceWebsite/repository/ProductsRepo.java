package com.blueconch.EcommerceWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blueconch.EcommerceWebsite.model.Product;

public interface ProductsRepo extends JpaRepository<Product, Integer> {

	@Query(value="select * from products p where p.category_id = ?1",nativeQuery = true)
	List<Product> getProductsByCategoryId(int categoryId);

}

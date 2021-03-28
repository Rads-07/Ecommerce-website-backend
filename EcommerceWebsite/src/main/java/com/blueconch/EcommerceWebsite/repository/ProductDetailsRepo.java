package com.blueconch.EcommerceWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.ProductDetail;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetail, Integer> {

	@Modifying
	@Transactional
	@Query(value = "select * from product_details where product_id = ?1", nativeQuery=true)
	List<ProductDetail> getProductDetailByProductId(int productId);


}

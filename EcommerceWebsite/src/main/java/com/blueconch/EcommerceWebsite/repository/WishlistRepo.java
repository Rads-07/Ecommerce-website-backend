package com.blueconch.EcommerceWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {
	
	@Query(value = "select * from wishlist w where w.user_id = ?1", nativeQuery = true)
	List<Wishlist> findAllByuserId(Integer userId);

	@Transactional
	@Modifying
	@Query(value= "delete from wishlist where user_id =?1", nativeQuery = true)
	void deleteByuserId(int userId);
	
	@Transactional
	@Modifying
	@Query(value= "delete from wishlist where user_id =?1 and product_id=?2", nativeQuery = true)
	void deleteByuserIdandProductId(int userId, int productId);
}

package com.blueconch.EcommerceWebsite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.Category;
import com.blueconch.EcommerceWebsite.repository.CategoryRepo;

@Service
public class CategoriesService {

	@Autowired
	private CategoryRepo repo;
	
	@Transactional
	public List<Category> getCategories() {

		List<Category> categories = new ArrayList<>();
		for(Category category: repo.findAll()) {
			categories.add(category);
		}
		return categories;
	}

	@Transactional
	public Category getCategory(int categoryId) {
		return repo.findById(categoryId).get();
	}

	public void addCategory(Category category) {
		repo.save(category);	
	}

	@Transactional
	public void updateCategory(Category category) {
		repo.save(category);
	}

	@Transactional
	public void deletecategory(int categoryId) {
		repo.deleteById(categoryId);
	}

	@Transactional
	public Category getCategoryByName(String categoryName) {
		return repo.getCategoryByName(categoryName);
	}

}

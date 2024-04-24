package com.daw.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.domain.Category;
import com.daw.domain.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

	public Optional<Category> getCategory(long categoryId) {
		return categoryRepository.getCategory(categoryId);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public boolean delete(long categoryId) {
		return getCategory(categoryId).map(category -> {
			categoryRepository.delete(categoryId);
			return true;
		}).orElse(false);
	}
}

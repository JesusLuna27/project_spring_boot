package com.daw.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.daw.domain.Category;

public interface CategoryRepository {

	List<Category> getAll();

	Optional<Category> getCategory(long categoryId);

	Category save(Category category);

	void delete(long categoryId);

}

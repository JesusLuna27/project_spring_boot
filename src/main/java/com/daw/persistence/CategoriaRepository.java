package com.daw.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.domain.Category;
import com.daw.domain.repositories.CategoryRepository;
import com.daw.persistence.crud.CategoriaCrudRepository;
import com.daw.persistence.entities.Categoria;
import com.daw.persistence.mappers.CategoryMapper;

@Repository
public class CategoriaRepository implements CategoryRepository {

	@Autowired
	private CategoriaCrudRepository categoriaCrudRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	public List<Category> getAll() {
		List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
		return categoryMapper.toCategories(categorias);
	}

	@Override
	public Optional<Category> getCategory(long categoryId) {
		Optional<Categoria> categoria = categoriaCrudRepository.findById(categoryId);
		return categoria.map(categoryMapper::toCategory);
	}

	@Override
	public Category save(Category category) {
		Categoria categoria = categoriaCrudRepository.save(categoryMapper.toCategoria(category));
		return categoryMapper.toCategory(categoria);
	}

	@Override
	public void delete(long categoryId) {
		categoriaCrudRepository.deleteById(categoryId);
	}
}

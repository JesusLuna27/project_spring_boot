package com.daw.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.domain.Category;
import com.daw.domain.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		return new ResponseEntity<List<Category>>(categoryService.getAll(), HttpStatus.OK);

	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getById(@PathVariable("categoryId") long categoryId) {
		return categoryService.getCategory(categoryId).map(category -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping()
	public ResponseEntity<Category> create(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<Category> update(@PathVariable("categoryId") long categoryId,
			@RequestBody Category category) {
		return categoryService.getCategory(categoryId).map(categoryDB -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Category> delete(@PathVariable("categoryId") long categoryId) {
		if (categoryService.delete(categoryId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

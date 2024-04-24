package com.daw.domain.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.domain.Product;
import com.daw.domain.repositories.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.getAll();
	}

	public Optional<Product> getProduct(long productId) {
		return productRepository.getProduct(productId);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public boolean delete(long productId) {
		return getProduct(productId).map(product -> {
			productRepository.delete(productId);
			return true;
		}).orElse(null);

	}

}

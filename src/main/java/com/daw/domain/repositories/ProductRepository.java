package com.daw.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.daw.domain.Product;

public interface ProductRepository {

	List<Product> getAll();

	Optional<Product> getProduct(long productId);

	Product save(Product product);

	void delete(long productId);

}

package com.daw.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.domain.Product;
import com.daw.domain.repositories.ProductRepository;
import com.daw.persistence.crud.ProductoCrudRepository;
import com.daw.persistence.entities.Producto;
import com.daw.persistence.mappers.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository productoCrudRepository;

	@Autowired
	private ProductMapper productMapper;

	public List<Product> getAll() {
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return productMapper.toProducts(productos);
	}

	public Optional<Product> getProduct(long productId) {
		Optional<Producto> producto = productoCrudRepository.findById(productId);
		return producto.map(product -> productMapper.toProduct(product));
	}

	public Product save(Product product) {
		Producto producto = productMapper.toProducto(product);
		producto = productoCrudRepository.save(producto);
		return productMapper.toProduct(producto);
	}

	public void delete(long productId) {
		productoCrudRepository.deleteById((long) productId);
	}
}

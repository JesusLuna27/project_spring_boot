package com.daw.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

	List<Producto> findByPrecioLessThan(double precio);

	List<Producto> findByCategoriaNombre(String nombreCategoria);

	long countByStockGreaterThan(long stock);

}

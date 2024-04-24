package com.daw.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Categoria;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Long> {
	
	List<Categoria> findByNombreAndDescripcion(String nombre, String descripcion);

}
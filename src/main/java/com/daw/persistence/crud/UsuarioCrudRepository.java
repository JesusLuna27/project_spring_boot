package com.daw.persistence.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);

	long countByPedidosIsNotNull();
}
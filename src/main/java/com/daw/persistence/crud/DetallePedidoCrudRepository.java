package com.daw.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.DetallePedido;

public interface DetallePedidoCrudRepository extends CrudRepository<DetallePedido, Long> {

	List<DetallePedido> findByIdPedido(Integer idPedido);

	List<DetallePedido> findByIdProducto(Integer idProducto);
}

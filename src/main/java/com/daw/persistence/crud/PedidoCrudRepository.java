package com.daw.persistence.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Pedido;

public interface PedidoCrudRepository extends CrudRepository<Pedido, Long> {

	List<Pedido> findByFechaEnvioIsNull();

	List<Pedido> findByFechaEnvioAfter(Date fecha);

	List<Pedido> findByIdUsuario(int idUsuario);

}
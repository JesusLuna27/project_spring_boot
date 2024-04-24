package com.daw.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.domain.OrderDetail;
import com.daw.domain.repositories.OrderDetailRepository;
import com.daw.persistence.crud.DetallePedidoCrudRepository;
import com.daw.persistence.entities.DetallePedido;
import com.daw.persistence.mappers.OrderDetailMapper;

@Repository
public class DetallePedidoRepository implements OrderDetailRepository {

	@Autowired
	private DetallePedidoCrudRepository detallePedidoCrudRepository;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	public List<OrderDetail> getAll() {
		List<DetallePedido> detallesPedidos = (List<DetallePedido>) detallePedidoCrudRepository.findAll();
		return orderDetailMapper.toOrdersDetails(detallesPedidos);
	}

	public Optional<OrderDetail> getOrderDetail(long orderDetailId) {
		Optional<DetallePedido> detallePedido = detallePedidoCrudRepository.findById(orderDetailId);
		return detallePedido.map(orderDetailMapper::toOrderDetail);
	}

	public OrderDetail save(OrderDetail orderDetail) {
		DetallePedido detallePedido = detallePedidoCrudRepository.save(orderDetailMapper.toDetallePedido(orderDetail));
		return orderDetailMapper.toOrderDetail(detallePedido);
	}

	public void delete(long orderDetailId) {
		detallePedidoCrudRepository.deleteById(orderDetailId);
	}
}
package com.daw.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.domain.Order;
import com.daw.domain.repositories.OrderRepository;
import com.daw.persistence.crud.PedidoCrudRepository;
import com.daw.persistence.entities.Pedido;
import com.daw.persistence.mappers.OrderMapper;

@Repository
public class PedidoRepository implements OrderRepository {

	@Autowired
	private PedidoCrudRepository pedidoCrudRepository;

	@Autowired
	private OrderMapper orderMapper;

	public List<Order> getAll() {
		List<Pedido> pedidos = (List<Pedido>) pedidoCrudRepository.findAll();
		return orderMapper.toOrders(pedidos);
	}

	@Override
	public Optional<Order> getOrder(long orderId) {
		Optional<Pedido> pedido = pedidoCrudRepository.findById(orderId);
		return pedido.map(orderMapper::toOrder);
	}

	@Override
	public Order save(Order order) {
		Pedido pedido = orderMapper.toPedido(order);
		pedido = pedidoCrudRepository.save(pedido);
		return orderMapper.toOrder(pedido);
	}

	@Override
	public void delete(long orderId) {
		pedidoCrudRepository.deleteById((long) orderId);
	}
}

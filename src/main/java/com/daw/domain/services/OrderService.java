package com.daw.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.domain.Order;
import com.daw.domain.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAll() {
		return orderRepository.getAll();
	}

	public Optional<Order> getOrder(long orderId) {
		return orderRepository.getOrder(orderId);
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}

	public boolean delete(long orderId) {
		return getOrder(orderId).map(order -> {
			orderRepository.delete(orderId);
			return true;
		}).orElse(null);

	}

}

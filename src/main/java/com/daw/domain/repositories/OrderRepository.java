package com.daw.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.daw.domain.Order;

public interface OrderRepository {

	List<Order> getAll();

	Optional<Order> getOrder(long orderId);

	Order save(Order order);

	void delete(long orderId);

}

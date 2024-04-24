package com.daw.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.daw.domain.OrderDetail;

public interface OrderDetailRepository{

	List<OrderDetail> getAll();

	Optional<OrderDetail> getOrderDetail(long orderDetailId);

	OrderDetail save(OrderDetail orderDetail);

	void delete(long orderDetailId);

}

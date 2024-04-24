package com.daw.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.domain.OrderDetail;
import com.daw.domain.repositories.OrderDetailRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	public List<OrderDetail> getAll() {
		return orderDetailRepository.getAll();
	}

	public Optional<OrderDetail> getOrderDetail(long orderDetailId) {
		return orderDetailRepository.getOrderDetail(orderDetailId);
	}

	public OrderDetail save(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}

	public boolean delete(long orderDetailId) {
		return getOrderDetail(orderDetailId).map(orderDetail -> {
			orderDetailRepository.delete(orderDetailId);
			return true;
		}).orElse(null);

	}
}

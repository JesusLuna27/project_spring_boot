package com.daw.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.domain.OrderDetail;
import com.daw.domain.services.OrderDetailService;

@RestController
@RequestMapping("/orders_details")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping
	public ResponseEntity<List<OrderDetail>> getAll() {
		return new ResponseEntity<List<OrderDetail>>(orderDetailService.getAll(), HttpStatus.OK);

	}

	@GetMapping("/{orderDetailId}")
	public ResponseEntity<OrderDetail> getById(@PathVariable("orderDetailId") long orderDetailId) {
		return orderDetailService.getOrderDetail(orderDetailId)
				.map(orderDetail -> new ResponseEntity<>(orderDetail, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping()
	public ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderDetail) {
		return new ResponseEntity<OrderDetail>(orderDetailService.save(orderDetail), HttpStatus.CREATED);
	}

	@PutMapping("/{orderDetailId}")
	public ResponseEntity<OrderDetail> update(@PathVariable("orderDetailId") long orderDetailId,
			@RequestBody OrderDetail orderDetail) {
		return orderDetailService.getOrderDetail(orderDetailId)
				.map(orderDetailDB -> new ResponseEntity<>(orderDetail, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{orderDetailId}")
	public ResponseEntity<OrderDetail> delete(@PathVariable("orderDetailId") long orderDetailId) {
		if (orderDetailService.delete(orderDetailId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

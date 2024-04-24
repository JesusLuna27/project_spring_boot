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

import com.daw.domain.Order;
import com.daw.domain.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> getAll() {
		return new ResponseEntity<List<Order>>(orderService.getAll(), HttpStatus.OK);

	}

	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getById(@PathVariable("orderId") long orderId) {
		return orderService.getOrder(orderId).map(order -> new ResponseEntity<>(order, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping()
	public ResponseEntity<Order> create(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.save(order), HttpStatus.CREATED);
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<Order> update(@PathVariable("orderId") long orderId, @RequestBody Order order) {
		return orderService.getOrder(orderId).map(orderDB -> new ResponseEntity<>(order, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Order> delete(@PathVariable("orderId") long orderId) {
		if (orderService.delete(orderId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

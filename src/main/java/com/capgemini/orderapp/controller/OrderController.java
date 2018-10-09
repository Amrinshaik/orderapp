package com.capgemini.orderapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.exception.OrderDoesnotExistsException;
import com.capgemini.orderapp.service.OrderService;

@RestController
public class OrderController {
	static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		logger.info("Add order  /order");
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable int orderId) throws OrderDoesnotExistsException {
		logger.info("Get order   /order/" + orderId);
		return new ResponseEntity<Order>(orderService.findOrderById(orderId), HttpStatus.OK);
	}

	@GetMapping("/order/customer/{customerId}")
	public ResponseEntity<List<Order>> findOrderByCustomerId(@PathVariable int customerId) {
		logger.info("Get order   /order/customer/" + customerId);
		return new ResponseEntity<List<Order>>(orderService.findOrderByCustomerId(customerId), HttpStatus.OK);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Order> deleteOrderById(@PathVariable int orderId) throws OrderDoesnotExistsException {
		logger.info("Delete order     /order/" + orderId);
		Order order = orderService.findOrderById(orderId);
		orderService.deleteOrder(order);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> findAllOrder() {
		logger.info("Get All orders    /orders");
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}
}

package com.capgemini.orderapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.exception.OrderDoesnotExistsException;
import com.capgemini.orderapp.repository.OrderRepository;
import com.capgemini.orderapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order addOrder(Order order) {
	return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Order order) {
	orderRepository.delete(order);
		
	}

	@Override
	public Order findOrderById(int orderId) throws OrderDoesnotExistsException {
		Optional<Order> orderFromDb = orderRepository.findById(orderId);
		if (orderFromDb.isPresent()) {
			return orderFromDb.get();
		}
		throw new OrderDoesnotExistsException("Order id " + orderId + " does not exist");
	}

	@Override
	public List<Order> findOrderByCustomerId(int customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Order> getAllOrders() {
	return orderRepository.findAll();
	}

}

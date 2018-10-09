package com.capgemini.orderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.orderapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
 
	@Query("{'CustomerId': ?0}")
	public List<Order> findByCustomerId(int customerId);
	
	
}

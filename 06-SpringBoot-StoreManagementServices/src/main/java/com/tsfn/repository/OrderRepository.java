package com.tsfn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsfn.beans.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	// Custom query method to find all orders
	List<Order> findAll();

	List<Order> findAllByPriceLessThan(double maxPrice);
}
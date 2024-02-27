package com.tsfn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Order;
import com.tsfn.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	public Optional<Order> getOrder(int id) {
		return orderRepository.findById(id);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> getAllOrdersByPriceLessThan(double price) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByPriceLessThan(price);
	}
}
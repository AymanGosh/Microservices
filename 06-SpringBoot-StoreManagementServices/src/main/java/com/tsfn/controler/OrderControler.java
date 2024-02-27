package com.tsfn.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.beans.Order;
import com.tsfn.services.OrderService;

@RestController

public class OrderControler {
	@Autowired
	OrderService orderService;

	@GetMapping(value = "/orders/order/{id}")
	public Optional<Order> getOrderByIdByPathVar(@PathVariable int id) {
		return orderService.getOrder(id);
	}

	@PostMapping(value = "/orders/add", consumes = "application/json")
	public void createDepartment(@RequestBody Order order) {
		orderService.createOrder(order);
	}

	@GetMapping(value = "/orders/getall")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	// f
	@GetMapping(value = "/orders/by-price")
	public List<Order> getAllOrdersByPriceLessThan(@RequestParam("price") double price) {
		return orderService.getAllOrdersByPriceLessThan(price);
	}
}
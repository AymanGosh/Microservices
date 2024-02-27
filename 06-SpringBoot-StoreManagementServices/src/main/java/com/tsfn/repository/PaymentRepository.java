package com.tsfn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsfn.beans.Order;
import com.tsfn.beans.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findAllByOrders_Method(String method);

	List<Payment> findByOrders(Order order);

}

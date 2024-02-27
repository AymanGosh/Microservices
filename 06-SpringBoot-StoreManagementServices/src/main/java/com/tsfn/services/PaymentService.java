package com.tsfn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Order;
import com.tsfn.beans.Payment;
import com.tsfn.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public void createPayment(Payment payment) {
		paymentRepository.save(payment);
	}

	public Optional<Payment> getPayment(int id) {
		return paymentRepository.findById(id);
	}

	public List<Payment> getAllPaymentsByPaymentMethod(String method) {
		return paymentRepository.findAllByOrders_Method(method);
	}

	public List<Payment> getPaymentByOrder(Order order) {
		return paymentRepository.findByOrders(order);
	}

	public List<Payment> getAllPayments() {

		return paymentRepository.findAll();
	}

	public void pay(Order order) {
		// Create a new Payment
		Payment payment = new Payment();
		// Builder.Payment
		payment.setTotalAmount(order.getPrice()); // Set the payment amount

		// Associate the Order with the Payment
		order.setPayment(payment); // Set the payment for the existing order
		payment.addNewOrder(order);
		// Save the Payment (which should cascade to the associated Order)
		paymentRepository.save(payment);

	}

	public void deletePayment(int id) {
		paymentRepository.deleteById(id);

	}
}
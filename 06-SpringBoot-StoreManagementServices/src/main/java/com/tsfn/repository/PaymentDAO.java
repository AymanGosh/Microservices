package com.tsfn.repository;

import org.springframework.stereotype.Repository;

import com.tsfn.beans.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void savePayment(Payment payment) {
		entityManager.persist(payment);
	}

}

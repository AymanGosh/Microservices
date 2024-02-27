package com.tsfn.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters and setters hashCode equal toString
@NoArgsConstructor
@AllArgsConstructor
@Builder // NEW instance

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI - server response on the index value of th id column
	@Column(name = "payment_id")
	private int payment_id;

	@Column(name = "payment_amount")
	private double amount;

	@JsonManagedReference
	@OneToMany(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public double getTotalAmount() {
		return amount;
	}

	public void setTotalAmount(double amount) {
		this.amount = amount;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addNewOrder(Order order) {
		orders.add(order);

	}

}
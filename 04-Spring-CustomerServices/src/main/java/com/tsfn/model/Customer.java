package com.tsfn.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//POJO class

@Component  // tell the spring core container to create bean from this pojo.

public class Customer {
	
	@Value("112")
	private int custID; 
	@Value("John")
	private String custName;
	
	@Autowired
	@Qualifier("acc2")
	private MyAcc account ;
	
	
	@PostConstruct // java annotation deprecate from java 9 | look to the lesson of Dawoud P.39 
	public void postConstruct() {
		System.out.println("@postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("@preDestroy");
	}
	
	public int getCustID() {
		return custID;
	}
	
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Account getAccount() {
		return (Account) account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custName=" + custName + ", account=" + account + "]";
	}

	
	
	
}

package com.tsfn.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tsfn.model.Account;
import com.tsfn.model.Customer;

@Configuration
@ComponentScan({"com.tsfn"})  
public class Config {
	
	// the next lines its in case we not used the notation approach to handle the type conflict in case we have 2 class like here or 
	// if we have to class implement the same interface 
	/*
	 * @Bean public Customer createCustomerInstance() { return new Customer(); }
	 * 
	 * @Bean (name= "acc1") public Account createAccIns() { return new Account(); }
	 * 
	 * @Bean (name= "acc2") public Account createAccIns2() { return new Account(); }
	 */
}

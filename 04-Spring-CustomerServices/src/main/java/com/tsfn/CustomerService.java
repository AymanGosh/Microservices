package com.tsfn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsfn.beans.PrototypeBean;
import com.tsfn.beans.SingletonBean;
import com.tsfn.conf.Config;
import com.tsfn.model.Account;
import com.tsfn.model.Customer;


// the next lines moved to configuration class
//@Configuration // this is the configuration of the application 
//@ComponentScan({"com.tsfn.model"})  //tell the spring core container where to find the relevant annotations 
public class CustomerService {

	public static void main(String[] args) {
		
		//build the spring-core  container from spring-context 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		//create bean of customer
		Customer cust1 = ctx.getBean(Customer.class);
		
		cust1.setCustID(111);
		cust1.setCustName("Zoubi");
		
		System.out.println(cust1);
		
		SingletonBean sinleton1 = ctx.getBean(SingletonBean.class);
		SingletonBean sinleton2 = ctx.getBean(SingletonBean.class);
		System.out.println(sinleton1.x);
		System.out.println(sinleton2.x);
		
		PrototypeBean proto1 = ctx.getBean(PrototypeBean.class);
		PrototypeBean proto2 = ctx.getBean("proto",PrototypeBean.class);
		System.out.println(proto1.x);
		System.out.println(proto2.x);
		
		((AnnotationConfigApplicationContext)ctx).close();

	}


}
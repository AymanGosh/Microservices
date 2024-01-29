package com.tsfn.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("proto")
@Scope("prototype")
public class PrototypeBean {
	public int x =(int)(Math.random()*100);
}

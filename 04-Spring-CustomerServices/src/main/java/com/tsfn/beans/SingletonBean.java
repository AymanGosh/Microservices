package com.tsfn.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("singleton") // always the scope is singleton 
public class SingletonBean {
	public int x =(int)(Math.random()*100);
}

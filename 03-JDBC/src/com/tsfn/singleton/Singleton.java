package com.tsfn.singleton;

// DP - ensure that a class has only one instance in the runtime 
public class Singleton {
	private static Singleton instance; 
	
	private Singleton () {
		
	}
	
	public static Singleton createInstance() {
		synchronized (instance){
			if(instance == null) {
				instance = new Singleton(); 
			}
			return instance;
		}
	}
	
}

package part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class HelloRunnable implements Runnable { 
	
	public void run() { 
		System.out.println("Hello from a thread! - Runnable"); 
	} 

}
class SimpleRunnable implements Runnable { 
	private int number; 

	public SimpleRunnable(int number) { 
		this.number = number; 
	} 

	public void run() { 
		for (int i = 0; i < 10; i++) { 
			System.out.print(" " + number); 
		} 
	} 
}

public class HelloThread extends Thread {

	public void run() {
		System.out.println("Hello from thread! - Thread");
	}
	public static void main(String[] args) {
//		new HelloThread().start();
//		(new Thread(new HelloRunnable())).start(); 
//		System.out.println("Hello from main");
		/************************/
		ExecutorService e = Executors.newFixedThreadPool(2); 
		
		for(int i=0;i<10;i++) { 
			System.out.println("creating a new task: " + i + " "); 				
			e.execute(new SimpleRunnable(i)); //Create several runnables, and execute them
		} 
		e.shutdown(); 
		/*
		 * This causes the executor not to accept any more tasks, 
		 * and to kill all of its threads when all the submitted tasks are done.
		 * */
	}
}

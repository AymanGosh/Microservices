package q3;




class NumberPrinter implements Runnable {

	private static final Object lock = new Object() ;
	private static int number =1 ;
	private boolean isEven ; 


	public NumberPrinter(boolean isEven) {
		this.isEven = isEven;
	}


	@Override
	public void run() {


		while(number <= 10)
		{
			synchronized(lock)
			{
				while((number %2 == 0 && !isEven) || (number %2  !=0  && isEven))
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

				}
				// Print the current number
				System.out.println(Thread.currentThread().getName() + ": " + number);
				number++;
				lock.notifyAll();

			}


			try {
				Thread.sleep(1500);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}




public class EvenOddPrinter {


	public static void main(String[] args) {
		// Create instances of NumberPrinter for odd and even numbers
        NumberPrinter oddPrinter = new NumberPrinter(false);
        NumberPrinter evenPrinter = new NumberPrinter(true);
        Thread oddThread = new Thread (oddPrinter , "OddPrinter");
        Thread evenThread = new Thread (evenPrinter , "evenPrinter");
        
        oddThread.start();
        evenThread.start();
        
        
        try {
			oddThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
       
        System.out.println("Printing complete.");
	}

}

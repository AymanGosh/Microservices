package HorsesRace;

public class Horse extends Thread {

	private int id,dist;
	
	public Horse(int id, int dist) {
		super();
		this.id = id;
		this.dist = dist;
	}
	
	public void run() {
		 while(dist>0) {
			 //try {   
				 System.out.print(this.id+" ");
				 //sleep(2000);
				 System.out.print("-");
			 //} catch (InterruptedException e) {}
			 this.dist--;
		 }
		 System.out.println("Hourse " + this.id + " Finish");
	}
	public static void main(String[] args) {
		System.out.println("the race start!!");
		for(int i = 0 ; i < 10; i++) {
			(new Horse(i,10)).start();
		}
	}

}

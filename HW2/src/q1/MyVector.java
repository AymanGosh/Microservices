package q1;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class MyVector {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int vectorSize=0;
		if(args.length==0) {
			System.exit(0);
		}
		try {
			vectorSize =Integer.valueOf(args[0]) ;
		} catch (NumberFormatException e) {
			System.out.println("Invalid integer input");
		}
		
		Vector<String> vector = new Vector<>();
		
		for(int i = 0 ; i < vectorSize; i++ ) {
			String str = scanner.nextLine();
			vector.add(str);
		}
		Collections.sort(vector);
		System.out.println(vector); 
		scanner.close();
	}
}

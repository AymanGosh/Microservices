package q2;
import java.util.Random;

public class Math {

	public static void main(String[] args) {
		System.out.println(Math.getAverage(-10, 10, 0));
		System.out.println(Math.getRandomNumber(-2, 2));
		System.out.println(Math.isEven(0));
		System.out.println(Math.isOdd(0));

	}
	public static double getAverage(int a, int b, int c) {
		return (a + b + c) / 3;	
	}
	public static int getRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	public static boolean isOdd(int num) {
		return num % 2 == 1;
	}

}

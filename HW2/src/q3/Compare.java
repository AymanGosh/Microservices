package q3;

public class Compare {

	public static void main(String[] args) {
		int length=0;
		if(args.length<2) {
			System.exit(0);
		}
		try {
			length =Integer.valueOf(args[1]) ;
		} catch (NumberFormatException e) {
			System.out.println("Invalid integer input");
		}
		String word=args[0];
		if(word.length() < length) {
			System.out.print("Shorter");
		}else if(word.length() > length) {
			System.out.print("Bigger");
		}else {
			System.out.print("Equal");
		}
	}
}

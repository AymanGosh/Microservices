package q2;

public class FoundSubString {

	public static void main(String[] args) {
		if(args.length<2) {
			System.exit(0);
		}
		final String word=args[0];
		final String subWord=args[1];
		
		if(word.contains(subWord)) {
			System.out.print("Found");
		}else {
			System.out.print("Not Found!");
		}
	}
}

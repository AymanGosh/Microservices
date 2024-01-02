package q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Service {
	private final int WORDS_NUM=5;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> wordsList = new ArrayList<>();
		Service s = new Service(); 
		for (int i = 0; i <s.WORDS_NUM; i++) {
            String word = scanner.nextLine();
            wordsList.add(word);
        }
		System.out.println(s.findLongestWord(wordsList));
		scanner.close();
	}
	
	private ArrayList<String> findLongestWord(ArrayList<String> wordsList) {
		// ex: [ 3 : [eat,ate,see] , 1 : [ a , b , c ] .... ]  
		HashMap<Integer, ArrayList<String>> wordsLength = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
		
		for (String word : wordsList) {
			int length = word.length();
			ArrayList<String> subWordsList;
			if(wordsLength.containsKey(length)) {
				subWordsList = wordsLength.get(length);
				subWordsList.add(word);
				if(length>=maxLength) {
					maxLength=length;
				}
			}else{	
				subWordsList =  new ArrayList<>();
				subWordsList.add(word);
			}
			wordsLength.put(length,subWordsList);
		}
		if(maxLength>0) {
			return wordsLength.get(maxLength);
		}else {
			return new ArrayList<>();
		}
	}
}

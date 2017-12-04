import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lek {

	
	
	public static void main(String [] args) {
		
		Lek lek = new Lek();
		
		
		lek.DayFourAdventCodeTwo("input.txt");
		
		//lek.testCasesTwo();
	}
	
	public boolean isValidPassPhrase(String passphrase) {
		
		String [] passPhrases = passphrase.split(" ");
		
		for(int i = 0; i < passPhrases.length; i++) {
			for(int j = 0; j < passPhrases.length; j++) {
				if(j == i) continue;
				boolean isConvertable = isStringConvertableTo(passPhrases[i], passPhrases[j]);
				if(isConvertable) {
					//System.out.println(passPhrases[i] + " " + passPhrases[j]);
					return false;
				}
			}
		}
		return true;
	}
	
	public void testCasesTwo() {
		
		String [] testStrings = {"abcde fghij", "abcde xyz ecdab", " ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio"};
		int amountOfValidPassPhrases = 0;
		for(String testString : testStrings) {
			boolean isValid = isValidPassPhrase(testString);
			if(isValid) amountOfValidPassPhrases++;
		}
		System.out.println(amountOfValidPassPhrases);
	}
	
	public void DayFourAdventCodeTwo(String fileName) {
		BufferedReader bufferReader;
		FileReader fileReader;
		int amountOfValidPassPhrases = 0;
		
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferReader.readLine()) != null) {
				boolean isValid = isValidPassPhrase(line);
				if(isValid) amountOfValidPassPhrases++;
			}
		}catch(IOException e) {
			
		}
		System.out.println(amountOfValidPassPhrases);
	}
	
	public boolean isStringConvertableTo(String theString, String convertableString) {
		
		if(theString.length() != convertableString.length()) return false;
		
		Map<String, Integer> charApperence = new HashMap<String, Integer>();
		char [] convertableStringAsCharArray = convertableString.toCharArray();
		for(char c : convertableStringAsCharArray) {
			String characterString = ""+c;
			boolean characterExists = charApperence.containsKey(characterString);
			if(characterExists) {
				Integer apperence = charApperence.get(characterString);
				apperence++;
				charApperence.put(characterString, apperence);
			}else {
				charApperence.put(characterString, 1);
			}
			
		}
		
		char [] theStringAsCharArray = theString.toCharArray();
		for(char c : theStringAsCharArray) {
			String characterString = ""+c;
			Integer apperence = charApperence.get(characterString);
			if(apperence == null || apperence <= 0) {
				return false;
			}
			apperence--;
			charApperence.put(characterString, apperence);
		}
		
		return true;
	}
	
	
	public void DayFourAdventCode(String fileName) {
		BufferedReader bufferReader;
		FileReader fileReader;
		int amountOfValidPassPhrases = 0;
		
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferReader.readLine()) != null) {
				boolean isValid = isValidPassPhrase(line);
				if(isValid) amountOfValidPassPhrases++;
			}
		}catch(IOException e) {
			
		}
		System.out.println(amountOfValidPassPhrases);
	}
	
	
	public void testCases() {
		
		String [] testStrings = {"aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa"};
		int amountOfValidPassPhrases = 0;
		for(String testString : testStrings) {
			boolean isValid = isValidPassPhrase(testString);
			if(isValid) amountOfValidPassPhrases++;
		}
		System.out.println(amountOfValidPassPhrases);
	}
	
	
}

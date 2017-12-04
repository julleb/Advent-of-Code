import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Lek {

	
	
	public static void main(String [] args) {
		
		Lek lek = new Lek();
		lek.DayFourAdventCode("input.txt");
		
	}
	
	public boolean isValidPassPhrase(String passphrase) {
		
		String [] passPhrases = passphrase.split(" ");
		
		Map<String, Integer> checker = new HashMap<String, Integer>();
		
		for(String passPhrase : passPhrases) {
			boolean passPhraseExists = checker.containsKey(passPhrase);
			if(passPhraseExists) {
				return false;
			}else {
				checker.put(passPhrase, 1);
			}
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

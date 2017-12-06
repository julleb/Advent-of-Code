import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Lek {

	
	
	public static void main(String [] args) {
		
		Lek lek = new Lek();
		lek.DayFiveAdventCode("input.txt");
		
		
	}
	
	private int walkOutOfTheArray(ArrayList<Integer> array) {
		int index = 0;
		int steps = 0;
	
		while(index >=0 && index < array.size()) {
			//System.out.println(index);
			//printArray(array);
			int offset = array.get(index);
			
			int newOffset = offset + 1;
			if(offset >= 3) newOffset = offset - 1;
			array.set(index, newOffset);
			index += offset;
			
			steps++;
		}
		return steps;
	}
	
	
	
	public void DayFiveAdventCode(String fileName) {
		BufferedReader bufferReader;
		FileReader fileReader;
		ArrayList<Integer> inputAsIntArray = new ArrayList<Integer>();
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferReader.readLine()) != null) {
				inputAsIntArray.add(Integer.parseInt(line));
			}
		}catch(IOException e) {
			
		}
		System.out.println("HELLO");
		int steps = walkOutOfTheArray(inputAsIntArray);
		System.out.println(steps);
		
	}
	
	private void printArray(ArrayList<Integer> array) {
		for(int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println("");
	}
	
	public void test() {
		
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(0, 3, 0, 1,-3));
		
		int steps = walkOutOfTheArray(array);
		System.out.println(steps);
	}
	
	
	
}

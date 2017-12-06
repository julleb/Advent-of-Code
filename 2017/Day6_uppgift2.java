import java.util.HashMap;
import java.util.Map;

public class Day6_uppgift2 {

	
	
	private Map<String, Integer> stateStorer;
	
	public Day6_uppgift2() {
		stateStorer = new HashMap<String, Integer>();
	}
	
	
	public void storeState(int [] array) {
		String stateAsString = stateToString(array);
		stateStorer.put(stateAsString, 1);
	}
	
	public boolean stateExists(int [] array) {
		
		String stateAsString = stateToString(array);
		return stateStorer.containsKey(stateAsString);
	}
	
	private String stateToString(int [] array) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i] +",");
		}
		return sb.toString();
	}
	
	public int findIndexWithMostBlocks(int [] array) {
		
		if(array == null || array.length == 0) {
			throw new IllegalArgumentException("Array is null or size is 0");
		}
		
		int index = 0;
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}
	
	
	public void distributeBlocksFromStartingIndex(int index, int [] array) {
		if(array == null || array.length == 0 || array.length <= index) {
			throw new IllegalArgumentException("Array is null or size is 0");
		}
		
		int amountOfBlocks = array[index];
		array[index] = 0;
		while(amountOfBlocks>0) {
			index++;
			if(index >= array.length) index = 0;
			
			array[index] +=1;
			amountOfBlocks--;
		}
	}
	
	public void day6(int [] array) {
		
		int steps = 0;
		
		//run until we get to an seens state
		while(!stateExists(array)) {
			storeState(array);
			steps++;
			int index = findIndexWithMostBlocks(array);
			distributeBlocksFromStartingIndex(index, array);
			
		}
		
		//restart the state-saver and start to count the steps
		steps = 0;
		stateStorer = new HashMap<String, Integer>();
		while(!stateExists(array)) {
			storeState(array);
			steps++;
			int index = findIndexWithMostBlocks(array);
			distributeBlocksFromStartingIndex(index, array);
		}
		
		System.out.println(steps);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Day6_uppgift2 day6 = new Day6_uppgift2();
		//int [] array = {2,4,1,2}; 
		int [] array = {2,8,8,5,4,2,3,1,5,5,1,2,15,13,5,14};  
		day6.day6(array);

	}
	
	
	

}

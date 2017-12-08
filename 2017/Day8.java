package testest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day8 {

	
	private Map<String, Integer> instructionMapper = new HashMap<String, Integer>();
	
	private int highestValue = -1;
	
	public void instructionTask(String fileName) {
		BufferedReader bufferReader;
		FileReader fileReader;
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferReader.readLine()) != null) {
				System.out.println(line);
				handleLine(line);
			}
			findMax();
			System.out.println("highest  Value seen " + highestValue );
		}catch(IOException e) {
			
		}
		
	}
	
	/*
	 * b inc 5 if a > 1
		a inc 1 if b < 5
		c dec -10 if a >= 1
		c inc -20 if c == 10
	 */
	
	private void handleLine(String line) {
		String [] lineArgs = line.split(" ");
		String instruction = lineArgs[0];
		String decInc = lineArgs[1];
		String valueAsString = lineArgs[2];
		String otherInstruction = lineArgs[4];
		String operator = lineArgs[5];
		String conditionValue = lineArgs[6];
		
		
		int value= Integer.parseInt(valueAsString);
		if(!instructionMapper.containsKey(otherInstruction)) {
			instructionMapper.put(otherInstruction, 0);
		}
		if(!instructionMapper.containsKey(instruction)) {
			instructionMapper.put(instruction, 0);
		}
		int instructionValue = instructionMapper.get(instruction);
		int otherInstructionValue = instructionMapper.get(otherInstruction);
		
		System.out.println(instruction + "=" + instructionValue);
		System.out.println(otherInstruction + "=" + otherInstructionValue);
		boolean conditionHolds = conditionHolds(otherInstructionValue, operator, conditionValue);
		if(conditionHolds) {
			System.out.println("Condition holds");
			System.out.println(value);
			
			if(decInc.equals("dec")) {
				instructionValue = instructionValue - value;
			}else { //inc
				instructionValue = instructionValue + value;
			}
			System.out.println("Instruction " + instruction + " gets the value " + instructionValue);
			instructionMapper.put(instruction, instructionValue);
			
		}
		
		if(instructionValue > highestValue) {
			highestValue = instructionValue;
		}
		
	}
	
	public boolean conditionHolds(int otherInstructionValue, String operator, String conditionValue) {
		int condValue = Integer.parseInt(conditionValue);
		if(operator.equals(">=")) {
			return otherInstructionValue >= condValue;
		}else if (operator.equals("<=")) {
			return otherInstructionValue <= condValue;
		}else if(operator.equals("!=")) {
			return otherInstructionValue != condValue;
		}else if(operator.equals(">")) {
			return otherInstructionValue > condValue;
		}else if(operator.equals("<")) {
			return otherInstructionValue < condValue;
		}else if(operator.equals("==")) {
			return otherInstructionValue == condValue;
		} 
		return false;
	}
	
	public void findMax() {
		String maxInstruction = null;
		int max = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : instructionMapper.entrySet()){
		    if(entry.getValue() > max) {
		    	max = entry.getValue();
		    	maxInstruction = entry.getKey();
		    }
		}
		System.out.println(maxInstruction + " " + max);
	}
	
	
	public static void main(String [] args) {
		Day8 day8 = new Day8();
		day8.instructionTask("input.txt");
	}
}

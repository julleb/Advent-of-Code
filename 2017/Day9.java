package testest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day9 {

	
	
	
	
	public void streamingProcessing(String fileName) {
		BufferedReader bufferReader;
		FileReader fileReader;
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			StringBuilder streamStringBuilder = new StringBuilder();
			while((line = bufferReader.readLine()) != null) {
				streamStringBuilder.append(line);
				
			}
			String stream = streamStringBuilder.toString();
			int score = getScoreOfGroups(stream);
			System.out.println(score);
		}catch(IOException e) {
			
		}
	}
	
	public int getScoreOfGroups(String stream) {
		char [] streamCharArray = stream.toCharArray();
		
		boolean garbage = false;
		int depth = 0;
		int score = 0;
		for(int i = 0; i < streamCharArray.length; i++) {
			char c = streamCharArray[i];
			if(c == '!') {
				//Skip the next one
				i++;
				continue;
			}
			if(c == '<') {
				garbage = true;
				
			}else if(c == '>') {
				garbage = false;
			}
			if(garbage == false) {
				if(c == '{') {
					depth++;
				}else if(c == '}'){
					//System.out.println("Depth is " + depth) ;
					score += depth;
					depth--;
				}
			}else if(garbage == true) {
				
			}
			
		}
		//System.out.println(score);
		return score;
	}
	
	
	public static void main(String [] args) throws Exception {
		Day9 day9 = new Day9();
		day9.streamingProcessing("input.txt");
		
	}
	

}

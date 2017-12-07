package testest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day7_One {

	private Map<String, Disk> diskFinder = new HashMap<String, Disk>();
	private String lastDisk;
	private class Disk {
		
		String diskName;
		ArrayList<Disk> childs;
		Disk parentDisk;
		String weight;
		
		public Disk(String diskName) {
			childs = new ArrayList<Disk>();
			this.diskName = diskName;
			
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public void setParentNode(Disk parentDisk) {
			this.parentDisk = parentDisk;
		}
		public void addChild(Disk childNode) {
			childs.add(childNode);
		}
	}
	
	
	public void buildTower(String fileName) {
		
		BufferedReader bufferReader;
		FileReader fileReader;
		ArrayList<Integer> inputAsIntArray = new ArrayList<Integer>();
		try {
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferReader.readLine()) != null) {
				createDisk(line);
			}
			findParent(lastDisk);
		}catch(IOException e) {
			
		}
	}
	
	public void createDisk(String line) {
		String [] splittedLine = line.split(" ");
		String diskName = splittedLine[0];
		String  weight = splittedLine[1];
		
		Disk disk;
		if(diskFinder.containsKey(diskName)) {
			disk = diskFinder.get(diskName);
		}else {
			disk = new Disk(diskName);
		}
		lastDisk = diskName;
		disk.setWeight(weight);
		
		
		if(line.contains("->")) {
			splittedLine = line.split("->");
			String [] childs = splittedLine[1].split(",");
			for(int i = 0; i < childs.length; i++) {
				String childName = childs[i].trim();
				Disk diskChild = new Disk(childName);
				if(diskFinder.containsKey(childName)) {
					diskChild = diskFinder.get(childName);
				}
				
				diskChild.setParentNode(disk);
				diskFinder.put(childName, diskChild);
				disk.addChild(diskChild);
				Disk test = diskFinder.get(diskChild.diskName);
				
			}
		}

		diskFinder.put(diskName, disk);
	}
	
	public void findParent(String startingDisk) {
		Disk disk = diskFinder.get(startingDisk);
		while(disk.parentDisk != null) {
			disk = disk.parentDisk;
		}
		System.out.println(disk.diskName);
	}
	
	
	
	public static void main(String [] args) {
		Day7 day7 = new Day7();
		day7.buildTower("input.txt");
	}
	
	
	
}

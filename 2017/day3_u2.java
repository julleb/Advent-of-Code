package testest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mejn {

	public static void main(String[] args) {
		
		int until = 265149;
		ArrayList<YandX> pos = doSpiralCalculationUntil(until);
		
		//int path = calcPath(pos.get(until-1), pos.get(0));
		//System.out.println(path);
		
		int next = doSpiralCalculationUntilUppgift2(until);
		
		System.out.println(next);
		
	}
	
	
	private static class YandX {
		public int X;
		public int Y;
		
		public YandX(int Y, int X) {
			this.Y = Y;
			this.X = X;
		}
		
		public String toString() {
			return Y + " " + X;
		}
	}

	
	public static int getNeighbourSum(Map<String, Integer> map, int y, int x) {
		
		int nSum = 0;
		int tempX, tempY;
		tempX = x;
		tempY = y;
		
		System.out.println("y="+y + " x="+x);
		
		tempY = y + 1;
		tempX = x;
		System.out.println("tempy="+tempY + " tempx="+tempX);
		Integer neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println(neighbour);
		
		tempY = y + 1;
		tempX = x + 1;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempX = x + 1;
		tempY = y;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempY = y - 1;
		tempX = x + 1;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempY = y - 1;
		tempX = x;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempY = y - 1;
		tempX = x - 1;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempX = x - 1;
		tempY = y;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		tempY = y + 1;
		tempX = x - 1;
		neighbour = map.get(tempY + "," + tempX);
		if(neighbour != null) nSum += neighbour;
		
		System.out.println("tempy="+tempY + " tempx="+tempX);
		System.out.println(neighbour);
		
		return nSum;
	}

	
	
	
public static int doSpiralCalculationUntilUppgift2(Integer number) {
		
		int nextStep = 0;
		
		int right = 1;
		int up = 1;
		int left = 2;
		int down = 2;
		
		int y,x;
		y = x = 0;
		
		int counter = 1;
		Map<String, Integer> pos = new HashMap<String, Integer>();
		pos.put(y + ","+x, counter);
		
		int oldestCounter = 1;
		
		boolean timeToBreak = false;
		while(true) {
			if(nextStep == 0) { //right
				int temp = 0;
				while(temp < right) {
					x++;
					oldestCounter = counter;
					counter = getNeighbourSum(pos, y, x);
					if(timeToBreak) {
						return oldestCounter;
					}
					System.out.println("Gonna put " + y + "," + x + " to counter=" + counter);
					pos.put(y + ","+x, counter);
					if(counter >= number) timeToBreak = true;
					temp++;
				}
				right+=2;
				nextStep++;
			}
			else if(nextStep == 1) { //up
				int temp = 0;
				while(temp < up) {
					y++;
					oldestCounter = counter;
					counter = getNeighbourSum(pos, y, x);
					if(timeToBreak) {
						return oldestCounter;
					}
					System.out.println("Gonna put " + y + "," + x + " to counter=" + counter);
					pos.put(y + ","+x, counter);
					if(counter >= number) timeToBreak = true;
					temp++;
				}
				up += 2;
				nextStep++;
			}
			else if(nextStep == 2) { ////left
				int temp = 0;
				while(temp < left) {
					x--;
					oldestCounter = counter;
					counter = getNeighbourSum(pos, y, x);
					if(timeToBreak) {
						return oldestCounter;
					}
					System.out.println("Gonna put " + y + "," + x + " to counter=" + counter);
					pos.put(y + ","+x, counter);
					if(counter >= number) timeToBreak = true;
					temp++;
				}
				left +=2;
				nextStep++;
			}else if(nextStep == 3) { //down
				int temp = 0;
				while(temp < down) {
					y--;
					oldestCounter = counter;
					counter = getNeighbourSum(pos, y, x);
					if(timeToBreak) {
						return oldestCounter;
					}
					System.out.println("Gonna put " + y + "," + x + " to counter=" + counter);
					pos.put(y + ","+x, counter);
					if(counter >= number) timeToBreak = true;
					temp++;
				}
				down += 2;
				nextStep = 0;
			}
			
			
		}
	}
	
	

}

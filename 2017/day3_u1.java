package testest;

import java.util.ArrayList;

public class Mejn {

	public static void main(String[] args) {
		
		ArrayList<YandX> pos = doSpiralCalculationUntil(265149);
		
		YandX yx = pos.get(16);
		System.out.println(yx.toString());
		
		int path = calcPath(pos.get(0), pos.get(265148));
		System.out.println(path);
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
	
	public static int calcPath(YandX first, YandX second) {
		
		int xled = Math.abs(first.X - second.X);
		int yled = Math.abs(first.Y - second.Y);
		
		
		
		return xled + yled;
	}
	
	public static ArrayList<YandX> doSpiralCalculationUntil(Integer number) {
		
		int nextStep = 0;
		
		int right = 1;
		int up = 1;
		int left = 2;
		int down = 2;
		
		int y,x;
		y = x = 0;
		
		ArrayList<YandX> pos = new ArrayList<YandX>();
		YandX yAndX = new YandX(y, x);
		pos.add(yAndX);
		
		while(pos.size() < number + 5) {
			if(nextStep == 0) { //right
				int temp = 0;
				while(temp < right) {
					x++;
					YandX yX = new YandX(y,x);
					pos.add(yX);
					temp++;
				}
				right+=2;
				nextStep++;
			}
			else if(nextStep == 1) { //up
				int temp = 0;
				while(temp < up) {
					y++;
					YandX yX = new YandX(y,x);
					pos.add(yX);
					temp++;
				}
				up += 2;
				nextStep++;
			}
			else if(nextStep == 2) { ////left
				int temp = 0;
				while(temp < left) {
					x--;
					YandX yX = new YandX(y,x);
					pos.add(yX);
					temp++;
				}
				left +=2;
				nextStep++;
			}else if(nextStep == 3) { //down
				int temp = 0;
				while(temp < down) {
					y--;
					YandX yX = new YandX(y,x);
					pos.add(yX);
					temp++;
				}
				down += 2;
				nextStep = 0;
			}
			
			
		}
		return pos;
		
		
	}
	//julleb
	

}

package testest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day10_u1 {

	
	
	public Day10_u1() {

	}
	
	public int[] initList() {
		int [] list = new int[256];
		for(int i = 0; i < list.length; i++)  {
			list[i] = i;
		}
		return list;
	}
	
	
	public void knotHash(int [] list, int [] sequence) {
		int cPosition = 0;
		int skipSize = 0;
		for(int i = 0; i < sequence.length; i++) {
			int length = sequence[i];
			System.out.println("lenght " + length);
			System.out.println("cpos " + cPosition);
			System.out.println("skip " + skipSize);
			System.out.println("pos: " + cPosition + " and pos " + (length-1));
			
			int test = length-1;
			if(length == 0) test=test+1;
			
			int k = (cPosition + test) % list.length;
			reverse(cPosition, k, list);
			System.out.println("new list " + Arrays.toString(list));
			cPosition += (length + skipSize);
			cPosition = cPosition % list.length;
			skipSize++;
		}
		
		
	}
	
	public int []  reverse(int x, int y, int [] array) {
		int tempX = x;
		int tempY = y;
		if(x == y ) return array;
		while(true) {

			int temp = array[tempX];
			array[tempX] =  array[tempY];
			array[tempY] = temp;
			
			tempX++;
			if(tempX >= array.length) tempX = 0;
			if(tempX == tempY) break;
			tempY--;
			if(tempY < 0) tempY = array.length-1;
			if(tempX == tempY) break;
			
			
		}
		
		return array;
	}
	
	public void test() {
		int [] list = {0, 1, 2, 3, 4};
		int [] sequence = {3, 4, 1, 5};
		knotHash(list, sequence);
		System.out.println(Arrays.toString(list));
		
	}
	
	
	public static void main(String [] args) {
		Day10_u1 day = new Day10_u1();
		//day.test();

		
		int [] array = day.initList();
		int [] sequence = {197,97,204,108,1,29,5,71,0,50,2,255,248,78,254,63};
		day.knotHash(array, sequence);
		System.out.println(Arrays.toString(array));
		System.out.println(array[0]*array[1]);
	}
}

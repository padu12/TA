package hw13mar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int[] array = {3,5,1,4,4};
		int[] arrayCount;
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		
		for (int i = getMin(array); i <= getMax(array);i++ ) {
			arrayList.add(i);
		}
		arrayCount = new int[arrayList.size()+1];
		
		for(int i: arrayCount) {
			i = 0;
		}
		
		for (int i = 0; i<array.length; i++) {
			arrayCount[array[i]]++;
		}
		
		System.out.println();
		System.out.println(arrayList);
	}
	
	public static int getMax(int[] array) {
		int maxNum = array[0];
		for (int i = 1; i<array.length; i++) {
			if (array[i] > maxNum) {
				maxNum = array[i];
			}
		}
		return maxNum;
	}
	
	public static int getMin(int[] array) {
		int min = array[0];
		for (int i : array) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}
	
	// 0 2 4 4 5 6 6 7 7 7
}

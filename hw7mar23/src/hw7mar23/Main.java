package hw7mar23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int l = 50;
		int[] array = new int[l];
		
		for (int i = 0; i<l; i++) {
			array[i] = i;
		}
		
//		System.out.println(Arrays.toString(array));
		
		array[1] = 0;
		int m = 2;
		
		while (m<l) {
			if(array[m] != 0) {
				int j = m*2;
				while(j<l) {
					array[j]=0;
					j += m;
				}
			}
			m++;
		}
		List<Integer> myList = new ArrayList<>();
		
		for (int i : array) {
			if (i != 0)
				myList.add(i);
		}
		
		System.out.println(myList);
	}
}

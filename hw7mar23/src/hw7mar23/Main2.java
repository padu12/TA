package hw7mar23;


import java.util.ArrayList;
import java.util.List;

public class Main2 {
	public static void main(String[] args) {
		int num = 50;
		int[] array = new int[num];
		List<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < num; i++) {			
			array[i] = i;
		}

		for (int i = 2; i < array.length; i++) {
			int divCount = 0;
			for (int l = 1; l <= i; l++) {
				if (i % l == 0) {
					divCount++;					
				}
			}
			if (divCount == 2) {
				arrayList.add(i);				
			}
		}

		System.out.println(arrayList);
	}
}

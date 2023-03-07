package hw7mar23;

public class Main {
	public static void main(String[] args) {
		int[] array = {4,1,2,5,3};
		System.out.println(getIndByNum(array, 6));
	}
	
	public static int getIndByNum(int[] array, int num) {
		for(int i=0; i<array.length; i++) {
			if (array[i] == num)
				return i;
		}
		return -1;
	}
}

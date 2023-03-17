package hw13mar;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
//		countingSort(100);
//		bubbleSort(100);
//		heapSort(100);
//		System.out.println();
//		countingSort(1000);
//		bubbleSort(1000);
//		heapSort(1000);
//		System.out.println();
//		countingSort(10000);
//		bubbleSort(10000);
//		heapSort(10000);
//		System.out.println();
		
		System.out.println("Counting sort:");
		countingSort(10);
		System.out.println();
		System.out.println("Bubble sort: ");
		bubbleSort(10);
		System.out.println();
		System.out.println("Heap sort: ");
		heapSort(10);
	}
	
	public static void countingSort (int n) {
		LocalTime localTimeBefore = LocalTime.now();
		int[] array = new int[n];
		int[] arrayCount;
		int[] result = new int[array.length];
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		Random rand = new Random();	
		
		for (int i = 0; i<array.length; i++) {
			array[i] = rand.nextInt(n);
		}
		
		for (int i = getMin(array); i <= getMax(array);i++ ) {
			arrayList.add(i);
		}
		arrayCount = new int[arrayList.size()+2];
		
		for (int i = 0; i<array.length; i++) {
			arrayCount[array[i]]++;
		}
		
//		System.out.println(Arrays.toString(arrayCount));
		
		for (int i = 1; i<arrayCount.length; i++) {
			arrayCount[i] += arrayCount[i-1];
		}
		
		System.out.println(Arrays.toString(array));
		
		for (int i : array) {
			result[arrayCount[i]-1] = i;
			arrayCount[i]--;
		}
		
		LocalTime localTimeAfter = LocalTime.now();
//		System.out.println("Counting sort: " + Duration.between(localTimeBefore, localTimeAfter));
		
		System.out.println(Arrays.toString(result));
	}

	private static int getMax(int[] array) {
		int maxNum = array[0];
		for (int i = 1; i<array.length; i++) {
			if (array[i] > maxNum) {
				maxNum = array[i];
			}
		}
		return maxNum;
	}
	
	private static int getMin(int[] array) {
		int min = array[0];
		for (int i : array) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}

	
	public static void bubbleSort(int n){
		LocalTime localTimeBefore = LocalTime.now();
		int[] arr = new int [n];
		Random rand = new Random();	
		
		for (int i = 0; i<arr.length; i++) {
			arr[i] = rand.nextInt(n);
		}
		System.out.println(Arrays.toString(arr));
		
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        LocalTime localTimeAfter = LocalTime.now();
//        System.out.println("Bubble sort: " + Duration.between(localTimeBefore, localTimeAfter));
        System.out.println(Arrays.toString(arr));
    }
	
	
	public static void heapSort(int N){
		LocalTime localTimeBefore = LocalTime.now();
		
		int[] arr = new int [N];
		Random rand = new Random();	
		
		for (int i = 0; i<arr.length; i++) {
			arr[i] = rand.nextInt(N);
		}
		System.out.println(Arrays.toString(arr));
  
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
  
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
  
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));

        LocalTime localTimeAfter = LocalTime.now();
//        System.out.println("Heap sort: " + Duration.between(localTimeBefore, localTimeAfter));
    }
  
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
  
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
  
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
  
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
  
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
	
	// 0 2 4 4 5 6 6 7 7 7
}

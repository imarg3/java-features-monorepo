package org.code;

public class SortingMain {
	public static void main(String[] args) {
		int[] arr = {5, 4, 2, 6, 3, 1};
		selectionSort(arr);
		System.out.println("Selection Sort :: Ascending Output :");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("");
		
		selectionSortDescending(arr);
		System.out.println("Selection Sort :: Descending Output :");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("");
		
		bubbleSort(arr);
		System.out.println("Bubble Sort :: Ascending Output :");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("");

		bubbleSortImproved(arr);
		System.out.println("Bubble Sort Improved :: Ascending Output :");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("");

		bubbleSortFurtherImproved(arr);
		System.out.println("Bubble Sort Further Improved :: Ascending Output :");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("");

		arr = new int[]{4, 2, 5, 3, 1, 6};
		insertionSort(arr); 
		System.out.println("Insertion Sort");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}

	// ascending
	public static void selectionSort(int[] arr) {
		// select i th element
		for (int i = 0; i < arr.length; i++) {
			// compare selected element with all elements after that
			for (int j = i+1; j < arr.length; j++) {
				// if i th element > j th element, swap them
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	// descending
	public static void selectionSortDescending(int[] arr) {
		// select i th element
		for (int i = 0; i < arr.length; i++) {
			// compare selected element with all elements after that
			for (int j = i+1; j < arr.length; j++) {
				// if i th element > j th element, swap them
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		int cnt = 0;
		// run n-1 passes for bubble sort
		for (int i = 0; i < arr.length-1; i++) {
			// compare all consecutive elements of the array
			for (int j = 0; j < arr.length-1; j++) {
				cnt++;
				// if j th element > j+1 th element, swap them
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Number of iterations: " + cnt);
	}
	
	public static void bubbleSortImproved(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				cnt++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Number of iterations: " + cnt);
	}
	
	// If Array is sorted
	public static void bubbleSortFurtherImproved(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length-1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length-1-i; j++) {
				cnt++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(flag == false)
				break;
		}
		System.out.println("Number of iterations: " + cnt);
	}
	
	public static void insertionSort(int[] arr) {
		int i, j, temp;
		for(i=1; i<arr.length; i++) {
			temp = arr[i];
			for(j=i-1; j>=0 && arr[j]>temp; j--)
				arr[j+1] = arr[j];
			arr[j+1] = temp;
		}
	}
}

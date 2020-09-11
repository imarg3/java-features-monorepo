package code;

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
		// run n-1 passes for bubble sort
		for (int i = 0; i < arr.length-1; i++) {
			// compare all consecutive elements of the array
			for (int j = 0; j < arr.length-1; j++) {
				// if j th element > j+1 th element, swap them
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

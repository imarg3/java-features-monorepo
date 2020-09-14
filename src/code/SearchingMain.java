package code;

import java.util.Scanner;

public class SearchingMain {
	public static void main(String[] args) {
		int numbers[] = {21, 53, 45, 98, 35, 14, 67, 54, 32, 16};
		int valueToSearch = 45;
		int indexOfValue = SearchingMain.linearSearch(numbers, valueToSearch);
		System.out.println("Linear Search :");
		System.out.println(indexOfValue);
		
		// Binary Search for String
		String[] stringArray = {"arpit", "gupta", "java", "python", "technologist"};
		int stringExists = binarySearchStrings(stringArray, "technologist");
		if(stringExists == -1)
			System.out.println("String not found!");
		else
			System.out.println("String found at index : " + stringExists);
		
		try(Scanner sc = new Scanner(System.in)){
			int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
			System.out.print("Enter number to find: ");
			int key = sc.nextInt();
			//int index = binarySearch(arr, key);
			int index = recursiveBinarySearch(arr, 0, arr.length-1, key);
	
			if(index == -1)
				System.out.println("Element not found.");
			else
				System.out.println("Element found at index " + index);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static int linearSearch(int[] numbers, int value) {
		
		for(int index = 0; index < numbers.length; index++) {
			if(numbers[index] == value)
				return index;
		}
		
		return -1;
	}

	public static int binarySearch(int[] arr, int key) {
		int left = 0, right = arr.length-1, mid;
		while(left <= right) {
			mid = (left + right) / 2;
			if(key == arr[mid])
				return mid;
			if(key < arr[mid])
				right = mid - 1;
			else // if(key > arr[mid])
				left = mid + 1;
		}
		return -1; // element not found
	}

	public static int recursiveBinarySearch(int[] arr, int left, int right, int key) {
		// if invalid partition, return element not found.
		if(right < left)
			return -1;
		// find middle of partition
		int mid = (left + right) / 2;
		// if key is same as middle element, return its index
		if(key == arr[mid])
			return mid;
		int index;
		// if key is smaller than middle element, search in left partition
		if(key < arr[mid])
			index = recursiveBinarySearch(arr, left, mid-1, key);
		// if key is greater than middle element, search in right partition
		else // if(key > arr[mid])
			index = recursiveBinarySearch(arr, mid+1, right, key);
		return index;
	}
	
	/*
	 // Tail Recursion
	 public static int recBinarySearch(int[] arr, int left, int right, int key) {
		// if invalid partition, return element not found.
		if(right < left)
			return -1;
		// find middle of partition
		int mid = (left + right) / 2;
		// if key is same as middle element, return its index
		if(key == arr[mid])
			return mid;
		return key < arr[mid] ? 
				recBinarySearch(arr, left, mid-1, key): 
				recBinarySearch(arr, mid+1, right, key);
	}

	 */
	
	// Binary Search for an array of strings
	public static int binarySearchStrings(String[] arr, String key) {
		// Base/Terminating condition
		int left = 0, right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int result = key.compareTo(arr[mid]);
			
			// Check if key is present at mid 
			if(result == 0) {
				return mid;
			}
			
			// If key greater, ignore left half
			if(result > 0 ) {
				left = mid + 1;
			}
			// If key smaller, ignore right half
			else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
	// Fibonacci Search
	//	public static 
}

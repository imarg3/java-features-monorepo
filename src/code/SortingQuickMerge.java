package code;

import java.util.Arrays;

public class SortingQuickMerge {
	public static void quickSort(int[] a, int left, int right) {
		//0. if single element or invalid partition, stop.
		//1. consider left-most element as pivot
		int i = left, j = right, pivot = a[left];
		if(left >= right)
			return;
		while(i < j) {
			//2. from left find element greater than pivot - ith element
			while(i <= right && a[i] <= pivot)
				i++;
			//3. from right find element less or equal to pivot - jth element
			while(j >= left && a[j] > pivot)
				j--;
			//4. if i & j not crossed, then swap ith element with jth element
			if(i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		} //5. repeat steps 2-4 until, i & j cross each other
		// 6. swap jth element with pivot=a[left]
		int temp = a[left];
		a[left] = a[j];
		a[j] = temp;
		// 7. apply quick sort to the left partition
		quickSort(a, left, j - 1);
		// 8. apply quick sort to the right partition
		quickSort(a, j + 1, right);
	}
	
	public static void mergeSort(int[] a, int left, int right) {
		//0. if single element in partition or invalid partition, return
		if(left >= right)
			return;
		//1. divide array into two equal partitions
		int mid = (left + right) / 2;
		//2. apply merge sort to left partition - left to mid
		mergeSort(a, left, mid);
		//3. apply merge sort to right partition - mid+1 to right
		mergeSort(a, mid+1, right);
		//4. create temp array to accomodate both partitions
		int[] temp = new int[right - left + 1];
		//5. merge both sorted partitions into temp array
		int i=left, j=mid+1, k=0;
		while(i <= mid && j <= right) {	
			if(a[i] < a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		while(i <= mid)
			temp[k++] = a[i++];
		while(j <= right)
			temp[k++] = a[j++];
		//6. overwrite temp array back to the main array
		for (i = 0; i < temp.length; i++)
			a[left+i] = temp[i];
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 3, 9, 1, 7, 2, 8, 4, 5};
		System.out.println(Arrays.toString(arr));
		//quickSort(arr, 0, arr.length-1);
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}

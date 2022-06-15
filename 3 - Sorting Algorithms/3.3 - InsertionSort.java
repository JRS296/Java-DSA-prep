//File Code: 3.3 - Searching Algorithms - Insertion Sort

//Code: Insertion sort in Java
import java.util.Arrays;

class InsertionSort {
	void insertionsort(int arr[])
	{
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.insertionsort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
	}
} 

// Time Complexity: {Best Case: O(n), Worst Case: O(n^2), Average Case: O(n^2)}
// Space Complexity: O(1)

// Explanation:
/*
Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one
 item at a time. It is much less efficient on large lists than more advanced algorithms such 
 as quicksort, heapsort, or merge sort.
 */

// Algorithm:
/*
Step 1 - If the element is the first element, assume that it is already sorted. Return 1.
Step 2 - Pick the next element, and store it separately in a key.
Step 3 - Now, compare the key with all elements in the sorted array.
Step 4 - If the element in the sorted array is smaller than the current element, then move to the next element. Else, shift greater elements in the array towards the right.
Step 5 - Insert the value.
Step 6 - Repeat until the array is sorted.
 */
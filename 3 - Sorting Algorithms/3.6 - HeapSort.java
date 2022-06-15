//File Code: 3.6 - Searching Algorithms - Heap Sort

//Code: Heap sort in Java
import java.util.Arrays;

class HeapSort {
	public void sort(int arr[])
	{
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		System.out.println(Arrays.toString(arr));
	}
}


// Time Complexity: {Best Case: O(nlog(n)), Worst Case: O(nlog(n)), Average Case: O(nlog(n))}
// Space Complexity: O(1)

// Explanation:
/*
Heap sort is a comparison-based sorting technique based on Binary Heap data structure. It is 
similar to selection sort where we first find the minimum element and place the minimum element
at the beginning. We repeat the same process for the remaining elements.
 */

// Algorithm:
/*
Step 1 - Construct a Binary Tree with given list of Elements.
Step 2 - Transform the Binary Tree into Min Heap.
Step 3 - Delete the root element from Min Heap using Heapify method.
Step 4 - Put the deleted element into the Sorted list.
Step 5 - Repeat the same until Min Heap becomes empty.
Step 6 - Display the sorted list.
 */
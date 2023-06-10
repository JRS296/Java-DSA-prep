// Java program of Quick Select

class GFG {

	// partition function similar to quick sort
	// Considers last element as pivot and adds
	// elements with less value to the left and
	// high value to the right and also changes
	// the pivot position to its respective position
	// in the final array.
	public static int partitionSmall(int[] arr, int low,
			int high) {
		int pivot = arr[high], pivotloc = low;
		for (int i = low; i <= high; i++) {
			// inserting elements of less value
			// to the left of the pivot location
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}

		// swapping pivot to the final pivot location
		int temp = arr[high];
		arr[high] = arr[pivotloc];
		arr[pivotloc] = temp;

		return pivotloc;
	}

	public static int partitionLarge(int[] arr, int low,
			int high) {
		int pivot = arr[high], pivotloc = low;
		for (int i = low; i <= high; i++) {
			// inserting elements of less value
			// to the left of the pivot location
			if (arr[i] > pivot) {
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}

		// swapping pivot to the final pivot location
		int temp = arr[high];
		arr[high] = arr[pivotloc];
		arr[pivotloc] = temp;

		return pivotloc;
	}

	// finds the kth position (of the sorted array)
	// in a given unsorted array i.e this function
	// can be used to find both kth largest and
	// kth smallest element in the array.
	// ASSUMPTION: all elements in arr[] are distinct
	public static int Kth(int[] arr, int low, int high, int k, int type) {
		// find the partition
		int partition = 0;

		if(type==1) partition = partitionSmall(arr, low, high); //To find smallest
		if(type==2) partition = partitionLarge(arr, low, high); //To find largest

		// if partition value is equal to the kth position,
		// return value at k.
		if (partition == k - 1)
			return arr[partition];

		// if partition value is less than kth position,
		// search right side of the array.
		else if (partition < k - 1)
			return Kth(arr, partition + 1, high, k, type);

		// if partition value is more than kth position,
		// search left side of the array.
		else
			return Kth(arr, low, partition - 1, k, type);
	}

	// Driver Code
	public static void main(String[] args) {
		int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
		int[] arraycopy = new int[] { 10, 4, 5, 8, 6, 11, 26 };

		int kPosition = 3;
		int length = array.length;

		if (kPosition > length) {
			System.out.println("Index out of bound");
		} else {
			// find kth smallest value
			System.out.println("K-th smallest element in array : "
							+ Kth(arraycopy, 0, length - 1,
									kPosition,1));

			System.out.println("K-th largest element in array : "
							+ Kth(arraycopy, 0, length - 1,
									kPosition,2));
		}
	}
}

/*
 * Quickselect is a selection algorithm to find the k-th smallest element in an
 * unordered list.
 * It is related to the quick sort sorting algorithm.
 * 
 * The algorithm is similar to QuickSort. The difference is, instead of
 * recurring for both sides
 * (after finding pivot), it recurs only for the part that contains the k-th
 * smallest element.
 * The logic is simple, if index of the partitioned element is more than k, then
 * we recur for
 * the left part. If index is the same as k, we have found the k-th smallest
 * element and we return.
 * If index is less than k, then we recur for the right part. This reduces the
 * expected complexity
 * from O(n log n) to O(n), with a worst-case of O(n^2).
 * 
 * TC - Best Case: O(1), Average Case: O(n), Worst Case: O(n^2)
 * 
 * Like quicksort, it is fast in practice, but has poor worst-case performance.
 * It is used in
 * The partition process is same as QuickSort, only recursive code differs.
 * There exists an algorithm that finds k-th smallest element in O(n) in worst
 * case, but QuickSelect performs better on average.
 */
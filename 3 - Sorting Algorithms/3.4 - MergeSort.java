//File Code: 3.4 - Searching Algorithms - Merge Sort

//Code: Merge sort in Java
import java.util.Arrays;

class MergeSort {

    // Merge two sub arrays L and M into array
    void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    void mergeSort(int array[], int left, int right) {
        if (left < right) {

            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }

    public static void main(String args[]) {
        int[] array = { 6, 5, 12, 10, 9, 1 };
        MergeSort ob = new MergeSort();
        // pass argument: array, first index and last index
        ob.mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));
    }
}

// Time Complexity: {Best Case: O(nlog(n)), Worst Case: O(nlog(n)), Average Case: O(nlog(n))}
// Space Complexity: O(n)

// Explanation:
/*
Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls 
itself for the two halves, and then it merges the two sorted halves. The merge() function is used
for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and
arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. 
 */

// Algorithm:
/*
Step 1: Find the middle index of the array. Middle = 1 + (last – first)/2
Step 2: Divide the array from the middle. 
Step 3: Call merge sort for the first half of the array. MergeSort(array, first, middle)
Step 4: Call merge sort for the second half of the array. MergeSort(array, middle+1, last)
Step 5: Merge the two sorted halves into a single sorted array.
 */
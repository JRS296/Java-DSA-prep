//File Code: 3.5 - Searching Algorithms - Quick Sort

//Code: Quick sort in Java
import java.util.Arrays;
class QuickSort {

    // method to find the partition position
    static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }
}

// Main class
class Main {
    public static void main(String args[]) {

        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // call quicksort() on array data
        QuickSort.quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}

// Time Complexity: {Best Case: O(nlog(n)), Worst Case: O(n^2), Average Case: O(nlog(n))}
// Space Complexity: O(1)

// Explanation:
/*
Quick sort is capable of sorting a list of data elements significantly faster (twice or thrice
faster) than any of the common sorting algorithms. It is one of the most efficient sorting 
algorithms and is based on the splitting of an array (partition) into smaller ones and swapping
(exchange) based on the comparison with 'pivot' element selected. Due to this, quick sort is 
also called as "Partition Exchange" sort. Like Merge sort, Quick sort also falls into the 
category of divide and conquer approach of problem-solving methodology.
 */

// Algorithm:
/*
Step 1 − Make any element as pivot
Step 2 − Partition the array on the basis of pivot
Step 3 − Apply quick sort on left partition recursively
Step 4 − Apply quick sort on right partition recursively
 */
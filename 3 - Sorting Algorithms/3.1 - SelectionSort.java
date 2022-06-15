//File Code: 3.1 - Searching Algorithms - Selection Sort

//Code: Selection sort in Java
import java.util.Arrays;

class SelectionSort {
    void selectionSort(int array[]) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
    // driver code
    public static void main(String args[]) {
        int[] data = { 20, 12, 10, 15, 2 };
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}

// Time Complexity: O(n^2) {Best Case: O(n^2), Worst Case: O(n^2), Average Case: O(n^2)}
// Space Complexity: O(1)

// Explanation:
/*
 * Selection sort is a simple sorting algorithm. This sorting algorithm is an
 * in-place comparison-based
 * algorithm in which the list is divided into two parts, the sorted part at the
 * left end and the
 * unsorted part at the right end. Initially, the sorted part is empty and the
 * unsorted part is the
 * entire list.
 */

// Algorithm:
/*
Step 1 − Set MIN to location 0
Step 2 − Search the minimum element in the list
Step 3 − Swap with value at location MIN
Step 4 − Increment MIN to point to next element
Step 5 − Repeat until list is sorted
 */
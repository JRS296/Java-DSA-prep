//File Code: 3.5 - Searching Algorithms - Quick Sort

//Code: Bubble sort in Java
import java.util.Arrays;

class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
}

// Time Complexity: {Best Case: O(n), Worst Case: O(n^2), Average Case: O(n^2)}
// Space Complexity: O(1)

// Explanation:
/*
Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until 
they are not in the intended order. Just like the movement of air bubbles in the water that 
rise up to the surface, each element of the array move to the end in each iteration. 
Therefore, it is called a bubble sort.
 */

// Algorithm:
/*
 * Step 1 − Starting from the first index, compare the first and the second elements.
 * Step 2 − If the first element is greater than the second element, they are swapped.
 * Step 3 − Now, compare the second and the third elements. Swap them if they are not in order.
 * Step 4 − The above process goes on until the last element.
 */
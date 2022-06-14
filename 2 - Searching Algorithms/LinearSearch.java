//File Code: 2.1 - Searching Algorithms - Linear Search

//Code:
public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = linearSearch(arr, x);

        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index: " + result);
    }
}

//Time Complexity: O(n) {Best Case: O(1), Worst Case: O(n), Average Case: O(n/2) = O(n)}
//Space Complexity: O(1)

//Explanation:
/*
 In computer science, a linear search or sequential search is a method for finding an element 
 within a list. It sequentially checks each element of the list until a match is found or the 
 whole list has been searched.
 */

//Algorithm:
/*
 Step 1: Traverse the array
 Step 2: Match the key element with array element
 Step 3: If key element is found, return the index position of the array element
 Step 4: If key element is not found, return -1
 */
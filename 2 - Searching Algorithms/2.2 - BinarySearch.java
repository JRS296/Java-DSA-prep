//File Code: 2.2 - Searching Algorithms - Binary Search

//Code:
class BinarySearchExample {
    public static void binarySearch(int arr[], int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println("Element is found at index: " + mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }
    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int key = 30;
        int last = arr.length - 1;
        binarySearch(arr, 0, last, key);
    }
}

// Code: Java implementation of recursive Binary Search
class BinarySearchRecursive{
    public static int binarySearch(int arr[], int first, int last, int key) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return binarySearch(arr, first, mid - 1, key);// search in left subarray
            } 
            else {
                return binarySearch(arr, mid + 1, last, key);// search in right subarray
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int key = 30;
        int last = arr.length - 1;
        int result = binarySearch(arr, 0, last, key);
        if (result == -1)
            System.out.println("Element is not found!");
        else
            System.out.println("Element is found at index: " + result);
    }
}

// Time Complexity: O(log(n)) {Best Case: O(1), Worst Case: O(log(n)), Average Case: O(log(n))}
// Space Complexity: O(1)

// Explanation:
/*
 * In computer science, binary search, also known as half-interval search, logarithmic search,
 * or binary chop, is a search algorithm that finds the position of a target value within a sorted 
 * array. Binary search compares the target value to the middle element of the array. If they 
 * are not equal, the half in which the target cannot lie is eliminated and the search continues on 
 * the remaining half, again taking the middle element to compare to the target value, and repeating 
 * this until the target value is found. If the search ends with the remaining half being empty, the 
 * target is not in the array.
 * 
 * Binary Search: Needs array to be in Ascending Order.
 */

// Algorithm:
/*
 * Step 1: Begin with the mid element of the whole array as search key.
 * Step 2: If the value of the search key is equal to the item then return index of the search key.
 * Step 3: Or if the value of the search key is less than the item in the middle of the interval, narrow
the interval to the lower half. Otherwise, narrow it to the upper half.
 * Step 4: Repeatedly check from the second point until the value is found or the interval is empty.
 */

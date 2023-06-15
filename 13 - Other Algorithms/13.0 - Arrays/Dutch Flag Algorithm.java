class DutchFlagAlgorithm {
    public int[] dutchFlagAlgorithm(int[] inputArray, int size) {
        int start = 0;
        int p = 0;
        int end = size - 1;
        int temp;
        while (p < end) {
            if (inputArray[p] == 2) {
                temp = inputArray[p];
                inputArray[p] = inputArray[start];
                inputArray[start] = temp;
                start++;
                p++;
            } else if (inputArray[p] == 0) {
                p++;
            } else {
                temp = inputArray[p];
                inputArray[p] = inputArray[end];
                inputArray[end] = temp;
                end--;
            }
        }
        return inputArray;
    }
}

//TC - O(N) SC - O(1)

/*
Dutch Flag Algorithm (DFA) is one of the most basic and important algorithms for arrays. It is used to segregate an array consisting of 3 numbers in linear time complexity.

The worst time complexity for DFA is O(n) and the space complexity for the algorithm is O(1). The problem statement is as follows:

An array consisting of 0s, 1s, and 2s is provided to you. The task is to write a function that segregates all the numbers together. The order can be anything.

Let's assume that the provided array A is
A = [1, 2, 0, 1, 2, 0, 1, 2, 0]
and the output expected is
A = [2, 2, 2, 0, 0, 0, 1, 1, 1]

To solve the problem, we need to first select the order. For this example, let's select 2,1,0.
Now we need to have 3 pointers namely start, end, and P, pointing to three different indices of the array.

The start will denote the first index of the middle element i.e 0 over here. The End will denote the last index of the middle element and pointer P will be used to traverse the array.

The loop will run while the P is not equal to End. As the P traverses, if P encounters 2, it will swap it with start and increment the start. Similarly, if P encounters 1, it will swap it with end and decrement end. 
 */

 //Sort based on order
 class example2 {
    public int[] threeNumberSort(int[] inputArray, int[] order) {
        int i = -1;
        int j = 0;
        int k = inputArray.length;

        while (j < k) {
            if(inputArray[j] == order[0] && i!=j) {
                i++;
                swap(inputArray[i], inputArray[j]);
            } else if (inputArray[j] == order[2] && k!= j) {
                k--;
                swap(inputArray[k], inputArray[j]);
            } else j++;
        }
        return inputArray;
    }

    public void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
 }
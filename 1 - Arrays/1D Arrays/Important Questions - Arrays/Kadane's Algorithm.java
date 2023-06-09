// Java program to print largest contiguous array sum

/*
To print the subarray with the maximum sum the idea is to maintain start index of maximum_sum_ending_here at current index so that whenever maximum_sum_so_far is updated with maximum_sum_ending_here then start index and end index of subarray can be updated with start and current index.

Follow the below steps to implement the idea:

Initialize the variables s, start, and end with 0 and max_so_far = INT_MIN and max_ending_here = 0
Run a for loop from 0 to N-1 and for each index i: 
Add the arr[i] to max_ending_here.
If max_so_far is less than max_ending_here then update max_so_far to max_ending_here and update start to s and end to i .
If max_ending_here < 0 then update max_ending_here = 0 and s with i+1.
Print values from index start to end.

Time Complexity: O(N)
Auxiliary Space: O(1)

Kadane’s Algorithm can be viewed both as greedy and DP. As we can see that we 
are keeping a running sum of integers and when it becomes less than 0, we reset 
it to 0 (Greedy Part). This is because continuing with a negative sum is way 
worse than restarting with a new range. Now it can also be viewed as a DP, at 
each stage we have 2 choices: Either take the current element and continue with 
the previous sum OR restart a new range. Both choices are being taken care of 
in the implementation.
 */

class Kadane {
	// Driver Code
	public static void main(String[] args)
	{
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is "
						+ maxSubArraySum(a));
	}

	// Function Call
	static int maxSubArraySum(int a[])
	{
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}
}

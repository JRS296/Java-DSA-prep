//GFG Q

/*
Given string str. You are allowed to delete only some contiguous characters if all the characters are the same in a single operation. The task is to find the minimum number of operations required to completely delete the string. 
Examples: 
 

Input: str = “abcddcba” 
Output: 4 
Delete dd, then the string is “abccba” 
Delete cc, then the string is “abba” 
Delete bb, then the string is “aa” 
Delete aa, then the string is null. 
Input: str = “abc” 
Output: 3 
 */

 // Java implementation of the approach
class GFG
{

	static int N = 10;

	// Function to return the minimum number of
	// delete operations
	static int findMinimumDeletion(int l, int r,
							int dp[][], String s)
	{

		if (l > r)
		{
			return 0;
		}
		if (l == r)
		{
			return 1;
		}
		if (dp[l][r] != -1)
		{
			return dp[l][r];
		}

		// When a single character is deleted
		int res = 1 + findMinimumDeletion(l + 1, r, dp, s);

		// When a group of consecutive characters
		// are deleted if any of them matches
		for (int i = l + 1; i <= r; ++i)
		{

			// When both the characters are same then
			// delete the letters in between them
			if (s.charAt(l) == s.charAt(i))
			{
				res = Math.min(res, findMinimumDeletion(l + 1, i - 1, dp, s)
						+ findMinimumDeletion(i, r, dp, s));
			}
		}

		// Memoize
		return dp[l][r] = res;
	}

	// Driver code
	public static void main(String[] args)
	{
		String s = "abcddcba";
		int n = s.length();
		int dp[][] = new int[N][N];
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(findMinimumDeletion(0, n - 1, dp, s));
	}
}

class Program {
  public static String longestPalindromicSubstring(String str) {
        int n = str.length();
        int table[][] = new int[n][n];
 
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = 1;
 
        // Check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }

      // Check for lengths greater than 2.
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1]>=1  && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = j-i;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        String ans = str.substring(start, start + maxLength);

        // for(int i=0; i<table.length; i++) {
        //     for(int j=0; j<table[0].length; j++) {
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }
 
        // Return length of LPS
        // return maxLength;
    return ans;
  }

  /*
  TC - "abaxyzzyxf"

  ---------- Test Case 1 ----------
1 0 2 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 0 1 0 0 0 0[5]0 
0 0 0 0 1 0 0 3 0 0 
0 0 0 0 0 1 1 0 0 0 
0 0 0 0 0 0 1 0 0 0 
0 0 0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 0 1 0 
0 0 0 0 0 0 0 0 0 1 

  */
}

//Longest Palindromic SUBSEQUENCE - LCS format
class Solution { //LCS with string and reverse of string -> LPS
    public int longestPalindromeSubseq(String s) {
        StringBuilder temp = new StringBuilder(s.length());
        temp.append(s).reverse();
        String str1 = s;
        String str2 = temp.toString();
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }
}

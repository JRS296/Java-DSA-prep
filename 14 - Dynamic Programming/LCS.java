import java.util.*;

//Link: https://www.algoexpert.io/questions/longest-common-subsequence
//LC - 

class Program { // LCS - with max string located at m*n
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String dp[][] = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = "";
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                else
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }

        List<Character> ans = new ArrayList<Character>();
        // System.out.println(dp[str1.length()][str2.length()]);
        for (char ch : dp[str1.length()][str2.length()].toCharArray())
            ans.add(ch);
        return ans;
    }
}

class Program2 {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
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

        List<Character> ans = new ArrayList<Character>();

        int i = str1.length();
        int j = str2.length();

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j])
                i--;
            else {
                ans.add(str1.charAt(i - 1));
                i--;
                j--;
            }
            if (dp[i][j] == 0)
                break;
        }

        for (int i1 = 0; i1 < dp.length; i1++) {
            for (int j1 = 0; j1 < dp[0].length; j1++) {
                System.out.print(dp[i1][j1] + " ");
            }
            System.out.println();
        }

        Collections.reverse(ans);
        return ans;
    }
}


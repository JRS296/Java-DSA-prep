class UnboundedKnapSack {

    /*
    - Same as 0/1 Knapsack, except each item can be used as many times to satisfy required wt/profit
    - Bottom Up Tabulation Style
     */
    public static void main(String[] args) {
        int p[] = {0,1,4,7,10};
        int wt[] = {0,1,2,3,5};
        int n = 4; //0 just for indexing purposes
        int m = 8; //Max capacity of Knapsack

        int MaximizedValue = unboundedKnapsack(m,n,p,wt);
        System.out.println(MaximizedValue);
    }

    public static int unboundedKnapsack(int m, int n, int p[], int wt[]) {
        int arr[][] = new int[p.length][m+1];
        for(int i=0; i<=n; i++) {
            for(int w=0; w<=m; w++) {
                //Important
                int include = 0;
                int exclude = 0;
                
                if(wt[i]<=w) include = p[i] + arr[i][w - wt[i]];
                if(i>0) exclude = arr[i-1][w];

                arr[i][w] = Math.max(include, exclude);
            }
        }

        //State pf array after 0/1 KnapSack
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return arr[n][m];
    }
}

//TC - O(m*n)
//OC - O(n^2)

//Example 1 - Number of Combinations to make change (Coin Change 2)

class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i=0; i<=amount; i++) {
            dp[0][i] = 0;
        }

        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }


        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                int include = 0;
                int exclude = 0;
                if(j-coins[i-1] < 0) exclude = dp[i-1][j];
                else {
                    include = dp[i][j - coins[i-1]];
                    exclude = dp[i-1][j];
                }

                dp[i][j] = include + exclude;
            }
        }

        for(int x[] : dp) {
            System.out.println(Arrays.toString(x));
        }

        return dp[coins.length][amount];
    }
}

//Example 2 - Fewest Number of coins to make change (Coin Change 1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0 ; i<=coins.length ; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 1 ; j<=amount ; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1 ; i<=coins.length ; i++){
            for(int j = 1 ; j<=amount ; j++){
                
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min( 1+ dp[i][j-coins[i-1]] , dp[i-1][j]); 
                }
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }

        if(dp[coins.length][amount] > amount)
                 return -1 ;
        return dp[coins.length][amount] ;
    }
}

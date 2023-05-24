import java.util.ArrayList;
import java.util.List;

class Knapsack_01 {

    /*
    - Fractional Knapsack can be solved via Greedy
    - If all cases are considered, TC = O(2^n), Therefore, we use DP to optimize
    - Done via Bottom Up Tabulation
     */
    public static void main(String[] args) {
        int p[] = {0,1,2,5,6};
        int wt[] = {0,2,3,4,5};
        int n = 4; //0 just for indexing purposes
        int m = 8; //Max capacity of Knapsack

        int MaximizedValue = knapsack01(m,n,p,wt);
        System.out.println(MaximizedValue);
    }

    public static int knapsack01(int m, int n, int p[], int wt[]) {
        int arr[][] = new int[p.length][m+1];
        for(int i=0; i<=n; i++) {
            for(int w=0; w<=m; w++) {
                //Important
                if(i==0 || w==0) arr[i][w] = 0;
                else if(wt[i]<=w) {
                    arr[i][w] = Math.max(p[i]+arr[i-1][w-wt[i]],arr[i-1][w]); //Very important
                }
                else {
                    arr[i][w] = arr[i-1][w];
                }
            }
        }

        //State of array after 0/1 KnapSack
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //To find out List of included Elements
        System.out.println(includedElements(m,n,arr, wt));

        return arr[n][m];
    }

    public static List<Integer> includedElements(int m, int n, int arr[][], int wt[]) {
        List<Integer> ans = new ArrayList<Integer>();
        int i=n, j=m;

        while(i>0 && j>0) {
            if(arr[i][j]==arr[i-1][j]) i--;
            else {
                ans.add(wt[i]);
                j = j-wt[i];
                i--;
            }
        }
        return ans;
    }
}

//TC - O(m*n)
//OC - O(n^2)

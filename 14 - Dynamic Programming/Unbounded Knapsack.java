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
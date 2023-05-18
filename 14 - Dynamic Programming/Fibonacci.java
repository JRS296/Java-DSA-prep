class Solution1 { //Recursive
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        return fib(N-1)+fib(N-2);
    }
}
/*
Recursive:
Runtime
11 ms
Beats
8.26%
Memory
39.5 MB
Beats
44.76%

TC - 2^n
SC - Recursive Stack Mem
*/

class Solution2 { //Top Down
  static int arr[] = new int[100];
  public int fib(int N) {
      if(N==0 || N==1) return N;
      if(arr[N]!=0) return arr[N];

      arr[N] = fib(N-1)+fib(N-2);
      return arr[N];
  }
}
/*
Recursive + Memoization
Runtime
0 ms
Beats
100%
Memory
39.8 MB
Beats
23.12%

TC - O(n)
SC - Recursive + O(n)
*/

class Solution3 { //Bottom Up
  public int fib(int N) {
      if(N==0 || N==1)
          return N;
      int arr[] = new int[N+1];
      arr[0] = 0;
      arr[1] = 1;

      for(int i=2; i<N+1; i++)
      {
          arr[i] = arr[i-1] + arr[i-2];
      }  
      return arr[N];
  }
}
/*
Bottom Up - Iterative - Full Memoization
Runtime
0 ms
Beats
100%
Memory
39.5 MB
Beats
57.77%

TC - O(n)
SC - O(n)
*/
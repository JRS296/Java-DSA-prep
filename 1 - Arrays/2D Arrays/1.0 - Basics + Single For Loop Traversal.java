class GFG {
    public static void print2DMatrix(
        int arr[][], int rows, int columns)
    {
 
        // Iterate over the range
        // [0, rows*columns]
        for (int i = 0;
             i < rows * columns; i++) {
 
            // Find row and column index
            int row = i / columns;
            int col = i % columns;
 
            // Print the element at
            // current index
            System.out.print(
                arr[row][col] + " ");
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        // Given matrix mat[][]
        int[][] mat = { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } };
 
        // Dimensions of the matrix
        int N = mat.length;
        int M = mat[0].length;
 
        // Function Call
        print2DMatrix(mat, N, M);
    }
}
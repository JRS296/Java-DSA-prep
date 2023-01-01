class GFG {
    public static void print2DMatrix(
            int arr[][], int rows, int columns) {
        // Iterate over the range [0, rows*columns]
        for (int i = 0; i < rows * columns; i++) {
            // Find row and column index
            int row = i / columns;
            int col = i % columns;
            System.out.print(arr[row][col] + " ");
        }
    }

    public static void main(String[] args) {
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

/*
int[][] name = new int[_size_][_size_];
int row = name.length;
int col = name[0].length; Size of row and col in an array.

System.out.println(Arrays.deepToString(_array_name_)); 

Initialize 2D ArrayList as List:
List<List<Integer>> ret = new ArrayList<List<Integer>>(); NOT List<List<Integer>> ret = new ArrayList<ArrayList<Integer>>();

2D array in 1D array format:
public static void print2DMatrix(
            int arr[][], int rows, int columns) {
        // Iterate over the range [0, rows*columns]
        for (int i = 0; i < rows * columns; i++) {
            // Find row and column index
            int row = i / columns;
            int col = i % columns;
            System.out.print(arr[row][col] + " ");
        }
    }
 */
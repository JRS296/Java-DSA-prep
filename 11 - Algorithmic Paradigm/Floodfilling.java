class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         DFSMarking(image, sr, sc, image[sr][sc], color);
//         return image;
//     }

//     private void DFSMarking(int[][] grid, int i, int j, int color, int NewColor) {
//     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != color) return;
//     grid[i][j] = NewColor;
//     DFSMarking(grid, i + 1, j, color, NewColor);
//     DFSMarking(grid, i - 1, j, color, NewColor);
//     DFSMarking(grid, i, j + 1, color, NewColor);
//     DFSMarking(grid, i, j - 1, color, NewColor);
// }
// }
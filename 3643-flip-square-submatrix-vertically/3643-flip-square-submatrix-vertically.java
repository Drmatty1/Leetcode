class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for( int i=x; i<(2*x+k)/2; i++ ){
            for( int j=y; j<y+k; j++ ){
                int t = grid[i][j];
                grid[i][j] = grid[x+k-(i-x)-1][j]; 
                grid[x+k-(i-x)-1][j] = t;
            }
        }
        return grid;
    }
}
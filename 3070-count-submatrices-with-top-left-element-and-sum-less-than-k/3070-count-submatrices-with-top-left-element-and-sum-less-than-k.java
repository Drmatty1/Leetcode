class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int r = grid.length, c = grid[0].length;
        int [][]dp = new int[r+1][c+1];
        int count = 0;
        for(int i=0; i<r; i++){
            int currRow = 0;  //prefSum of curr Row
            for(int j=0; j<c; j++){
                currRow += grid[i][j];
                dp[i+1][j+1] += dp[i][j+1] + currRow;
                if(dp[i+1][j+1] <= k) count++;
            }
        }
        return count;
    }
}
class Solution {
    int sol(int [][]arr, int i, int j){
        int r=arr.length, c= arr[0].length;
        if( i<0 || i>=r || j<0 || j>=c )return Integer.MAX_VALUE;
        if( i == r-1 && j == c-1 ) return arr[i][j];

        int ans = Math.min(sol(arr,i+1,j),sol(arr,i,j+1));
        return ans==Integer.MAX_VALUE?ans:(arr[i][j]+ans);

    }

    int sol1(int [][]arr, int i, int j, int[][]dp){
        int r=arr.length, c= arr[0].length;
        if( i<0 || i>=r || j<0 || j>=c )return Integer.MAX_VALUE;
        if( i == r-1 && j == c-1 ) return arr[i][j];

        if( dp[i][j] != 0 ) return dp[i][j];

        int ans = Math.min(sol1(arr,i+1,j, dp),sol1(arr,i,j+1, dp));
        return dp[i][j] = (arr[i][j]+ans);

    }

    public int minPathSum(int[][] grid) {
        // return sol(grid,0,0);

        int r=grid.length, c= grid[0].length;
        int [][]dp = new int[r][c];
        return sol1(grid,0,0,dp);
    }
}
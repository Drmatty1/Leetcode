class Solution {
    public int uniquePaths(int[][] grid) {
        int mod = 1000000007;
        int r = grid.length, c = grid[0].length;
        long [][][]dp = new long[r][c][2];
        dp[0][0][0] = 1;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i>0){
                    if(grid[i-1][j] == 0){
                        dp[i][j][0] = (dp[i-1][j][0]+dp[i-1][j][1])%mod;
                    }
                    else dp[i][j][0] = dp[i-1][j][1];
                }
                if(j>0){
                    if(grid[i][j-1] == 0){
                        dp[i][j][1] = (dp[i][j-1][0]+dp[i][j-1][1])%mod;
                    }
                    else dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }

        return (int)((dp[r-1][c-1][0]+dp[r-1][c-1][1])%mod);
    }
}
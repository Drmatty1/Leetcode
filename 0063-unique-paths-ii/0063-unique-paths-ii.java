class Solution {
    int r,c;
    int sol(int[][]a, int i, int j){

        if(i>=r || j>=c )return 0;
        if( i == r-1 && j == c-1){
            return a[i][j]==1?0:1;
        }

        if(a[i][j]==1)return 0;

        int x = sol(a,i,j+1);
        int y = sol(a,i+1,j);

        return x+y;

    }
    int sol2(int[][]a){

        int dp[][] = new int[r][c];
        if(a[r-1][c-1]==0) dp[r-1][c-1] = 1;

        for(int i=r-1; i>=0; i--){
            for(int j=c-1; j>=0; j--){

                if(a[i][j] == 1) continue;

                int x = (j+1<c)?dp[i][j+1]:0;
                int y = (i+1<r)?dp[i+1][j]:0;
                dp[i][j] += x+y;
            }
        }

        return dp[0][0];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        // return sol(obstacleGrid,0,0);
        return sol2(obstacleGrid);
    }
}
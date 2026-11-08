class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][]dp = new int[m][n][maxMove+1];
        int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int M = 1000000007;

        for(int move=1; move<=maxMove; move++){

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    for(int []d: dirs){
                        int ni = i+d[0], nj = j+d[1];
                        if(ni<0||ni>=m||nj<0||nj>=n){
                            dp[i][j][move] = (dp[i][j][move]+1)%M;
                        }
                        else{
                            dp[i][j][move] = (dp[i][j][move]+dp[ni][nj][move-1])%M;
                        }
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }
}
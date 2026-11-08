class Solution {
    int sol1(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int M = 1000000007;

        for (int move = 1; move <= maxMove; move++) {

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= move && i < m - move &&
                            j >= move && j < n - move)
                        continue;
                    for (int[] d : dirs) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            dp[i][j][move] = (dp[i][j][move] + 1) % M;
                        } else {
                            dp[i][j][move] = (dp[i][j][move] + dp[ni][nj][move - 1]) % M;
                        }
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }

    int sol2(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] prev = new int[m][n];
        int[][] curr ;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int M = 1000000007;

        for (int move = 1; move <= maxMove; move++) {
            curr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= move && i < m - move &&
                            j >= move && j < n - move)
                        continue;
                    for (int[] d : dirs) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            curr[i][j] = (curr[i][j] + 1) % M;
                        } else {
                            curr[i][j] = (curr[i][j] + prev[ni][nj]) % M;
                        }
                    }
                }
            }

            prev = curr;
        }

        return prev[startRow][startColumn];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return sol2(m,n,maxMove, startRow, startColumn);
    }
}
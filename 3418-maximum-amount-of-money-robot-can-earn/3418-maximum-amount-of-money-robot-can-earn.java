class Solution {
    int sol(int[][] coins, int t, int i, int j ){
        int r = coins.length, c = coins[0].length;
        if( i == r-1 && j == c-1 ){
            if( coins[i][j] < 0 ) return t>0?0:coins[i][j];
            return coins[i][j];
        }
        if( i<0 || i>=r || j<0 || j>=c ) return Integer.MIN_VALUE;

        int k = 0;
        int ans = Integer.MIN_VALUE;

        if( coins[i][j] < 0 && t >= 1 ){
            int op1 = k+sol( coins, t-1, i, j+1 );
            int op2 = k+sol( coins, t-1, i+1, j );
            ans = Math.max(ans, Math.max(op1,op2));
        }
    
        k = coins[i][j];
        int op1 = k+sol( coins, t, i, j+1 );
        int op2 = k+sol( coins, t, i+1, j );

        ans = Math.max(ans, Math.max(op1,op2));
        return ans;
    }
    int sol1(int[][] coins, int t, int i, int j, int[][][]dp ){
        int r = coins.length, c = coins[0].length;
        if( i == r-1 && j == c-1 ){
            if( coins[i][j] < 0 ) return t>0?0:coins[i][j];
            return coins[i][j];
        }
        if( i<0 || i>=r || j<0 || j>=c ) return Integer.MIN_VALUE;

        if( dp[i][j][t] != Integer.MIN_VALUE ) return dp[i][j][t];

        long k = 0;
        long ans = Integer.MIN_VALUE;

        if( coins[i][j] < 0 && t >= 1 ){
            long op1 = 1L*k+sol1( coins, t-1, i, j+1, dp );
            long op2 = 1L*k+sol1( coins, t-1, i+1, j, dp );
            ans = Math.max(ans, Math.max(op1,op2));
        }
    
        k = coins[i][j];
        long op1 = k+sol1( coins, t, i, j+1, dp );
        long op2 = k+sol1( coins, t, i+1, j, dp );

        ans = Math.max(ans, Math.max(op1,op2));
        return dp[i][j][t] = (int)ans;
    }
    public int maximumAmount(int[][] coins) {
        // return sol(coins,2,0,0);

        int r = coins.length, c = coins[0].length;
        int [][][]dp = new int[r][c][3];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return sol1(coins,2,0,0,dp);
    }
}
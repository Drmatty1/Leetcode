class Solution {
    int []pre;
    int [][]dp;
    int sol(int[]a, int i, int j){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxDiff = 0;
        // pick j
        maxDiff = pre[j]-pre[i] - sol(a,i,j-1);

        //pick i
        maxDiff = Math.max(maxDiff, pre[j+1]-pre[i+1] - sol(a,i+1,j));

        return dp[i][j] = maxDiff;
    }

    int sol2(int[]a){
        int n = a.length;
        dp = new int[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){

                int maxDiff = 0;
                // pick j
                maxDiff = pre[j]-pre[i] - dp[i][j-1];
                // pick i
                maxDiff = Math.max(maxDiff, pre[j+1]-pre[i+1] - dp[i+1][j]);

                dp[i][j] = maxDiff;
            }
        }
        return dp[0][n-1];
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        pre = new int[n+1];
        for(int i=0; i<n; i++) pre[i+1]=pre[i]+stones[i];
        
        // dp = new int[n][n];
        // for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        // return sol(stones,0,n-1);

        return sol2(stones);
    }
}













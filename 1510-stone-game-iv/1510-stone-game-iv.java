class Solution {
    boolean solOP(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (dp[i]) {
                continue;
            }
            for (int k = 1; i + k * k <= n; k++) {
                dp[i + k * k] = true;
            }
        }
        return dp[n];
    }
    public boolean winnerSquareGame(int n) {
        boolean []res = new boolean[n+1];
        res[1] = true;
        for(int i=2; i<=n; i++){
            int sq = 1;
            for(int j=1; sq<=i; j++){
                if(res[i-sq]==false){
                    res[i] = true;
                    break;
                }
                sq = j*j;
            }
        }
        return res[n];
    }
}
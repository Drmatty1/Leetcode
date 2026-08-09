class Solution {
    int [][]dp;

    int sol(int i, int sell, int []p){
        if(i>=p.length) return 0;

        if(dp[i][sell] != -1) return dp[i][sell];

        int max = 0;

        // tracnactiom
        if(sell == 0){
            max = -p[i] + sol(i+1,1,p);
        }
        else{
            max = p[i] + sol(i+2,0,p);
        }

        //skip
        max = Math.max(max, sol(i+1,sell,p));

        return dp[i][sell] = max;

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return sol(0,0,prices);
    }
}
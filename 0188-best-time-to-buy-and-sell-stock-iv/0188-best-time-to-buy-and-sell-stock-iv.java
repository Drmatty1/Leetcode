class Solution {
    int sol3(int[] prices, int transaction) {
        if (prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        int[][] dp = new int[transaction+1][n]; 
        
        for(int t=1; t<=transaction; t++){

            int maxDiff = -prices[0];

            for(int d=1; d<n; d++){

                dp[t][d] = Math.max( dp[t][d-1], prices[d] + maxDiff );

                //update maxdiff
                maxDiff = Math.max(maxDiff,( -prices[d] + dp[t-1][d] ));
            }
        }

        return dp[transaction][n-1];
       
    }

    public int maxProfit(int k, int[] prices) {
        return sol3(prices,k);
    }
}
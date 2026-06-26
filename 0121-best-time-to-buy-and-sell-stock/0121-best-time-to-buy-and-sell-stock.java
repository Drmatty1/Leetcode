class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int []suf = new int[n];
        suf[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--){
            suf[i] = Math.max(suf[i+1], prices[i]);
        }

        int ans = 0;
        for(int i=0; i<n-1; i++ ){
            ans = Math.max(ans, -prices[i]+suf[i+1]);
        }
        return ans; 
    }
}